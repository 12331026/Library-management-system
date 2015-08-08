package com.bv.cn.base.repository;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import javax.persistence.Entity;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.oro.text.regex.MalformedPatternException;
import org.apache.oro.text.regex.Pattern;
import org.apache.oro.text.regex.PatternCompiler;
import org.apache.oro.text.regex.PatternMatcher;
import org.apache.oro.text.regex.Perl5Compiler;
import org.apache.oro.text.regex.Perl5Matcher;
import org.hibernate.HibernateException;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.util.CollectionUtils;

public class AnnotationSessionFactoryBeanEx extends
		AnnotationSessionFactoryBean {
	private static final Log logger = LogFactory
			.getLog(AnnotationSessionFactoryBeanEx.class);
	private static final String annotatedClassesPropItem = "annotatedClassesLocations";
	private String[] annotatedClassesLocations;
	private String[] excludedClassesRegexPatterns;

	public void setAnnotatedClassesLocations(String[] annotatedClassesLocations) {
		this.annotatedClassesLocations = annotatedClassesLocations;
	}

	public void setExcludedClassesRegexPatterns(
			String[] excludedClassesRegexPatterns) {
		this.excludedClassesRegexPatterns = excludedClassesRegexPatterns;
	}

	protected void postProcessAnnotationConfiguration(
			AnnotationConfiguration config) throws HibernateException {
		Set<Class> annClasses = scanAnnotatedClasses();

		if (!(CollectionUtils.isEmpty(annClasses)))
			for (Class annClass : annClasses)
				config.addAnnotatedClass(annClass);
	}

	protected void scanPackages(Configuration config) {
		Set<Class> annClasses = scanAnnotatedClasses();

		if (!(CollectionUtils.isEmpty(annClasses)))
			for (Class annClass : annClasses)
				config.addAnnotatedClass(annClass);
	}
	
	private Set<Class> scanAnnotatedClasses() {
		ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
		MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(
				resourcePatternResolver);
		Set annotatedClasses = new HashSet();
		if (this.annotatedClassesLocations != null)
			try {
				for (String annClassesLocation : this.annotatedClassesLocations) {
					String annClassesLocationValues = getPropertiesValue(annClassesLocation);
					if (annClassesLocationValues != null)
						for (String annotatedClassesLocation : annClassesLocationValues
								.split(",")) {
							Resource[] resources = resourcePatternResolver
									.getResources(annotatedClassesLocation);
							for (Resource resource : resources) {
								MetadataReader metadataReader = metadataReaderFactory
										.getMetadataReader(resource);
								String className = metadataReader
										.getClassMetadata().getClassName();

								if ((isEntityClass(metadataReader))
										&& (!(isExcludedClass(className)))) {
									Class clazz = Class.forName(className);
									annotatedClasses.add(clazz);
									logger.debug("A entity class has been found. \n({})"
											+ clazz.getName());
								}
							}
						}
				}

			} catch (IOException e) {
				logger.error("I/O failure during classpath scanning, ({})"
						+ e.getMessage());
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				logger.error("Class not found, ({})" + e.getMessage());
				e.printStackTrace();
			} catch (LinkageError e) {
				logger.error("LinkageError ({})" + e.getMessage());
				e.printStackTrace();
			}

		return annotatedClasses;
	}

	private String getPropertiesValue(String propertiesFilePath) {
		String propertiesValue = "";
		try {
			if ((propertiesFilePath == null) || ("".equals(propertiesFilePath))) {
				return null;
			}

			URL url = getClass().getClassLoader().getResource(
					propertiesFilePath);
//			File configFile = new File(url.getFile());
			Properties props = new Properties();
			props.load(url.openStream());
			if (props != null) {
				propertiesValue = props
						.getProperty("annotatedClassesLocations");
			}
		} catch (Exception e) {
			logger.error("getPropertiesValue error ({})" + e.getMessage());
		}

		return propertiesValue;
	}

	private boolean isEntityClass(MetadataReader metadataReader) {
		Set annTypes = metadataReader.getAnnotationMetadata()
				.getAnnotationTypes();
		if (CollectionUtils.isEmpty(annTypes)) {
			return false;
		}

		return annTypes.contains(Entity.class.getName());
	}

	private boolean isExcludedClass(String className) {
		if (this.excludedClassesRegexPatterns == null) {
			return false;
		}

		PatternCompiler compiler = new Perl5Compiler();
		PatternMatcher matcher = new Perl5Matcher();
		try {
			for (String regex : this.excludedClassesRegexPatterns) {
				logger.debug("Pattern is: {}" + regex);
				Pattern pattern = compiler.compile(regex);
				if (matcher.matches(className, pattern)) {
					logger.debug("class [{}], matches [{}], so it is excluded."
							+ className + pattern.getPattern());
					return true;
				}
			}
		} catch (MalformedPatternException e) {
			logger.warn("Malformed pattern [{}]" + e.getMessage());
		}

		return false;
	}
}

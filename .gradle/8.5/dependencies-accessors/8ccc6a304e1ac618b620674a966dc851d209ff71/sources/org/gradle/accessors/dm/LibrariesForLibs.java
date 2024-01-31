package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the `libs` extension.
 */
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final ComLibraryAccessors laccForComLibraryAccessors = new ComLibraryAccessors(owner);
    private final OrgLibraryAccessors laccForOrgLibraryAccessors = new OrgLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

    /**
     * Returns the group of libraries at com
     */
    public ComLibraryAccessors getCom() {
        return laccForComLibraryAccessors;
    }

    /**
     * Returns the group of libraries at org
     */
    public OrgLibraryAccessors getOrg() {
        return laccForOrgLibraryAccessors;
    }

    /**
     * Returns the group of versions at versions
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Returns the group of bundles at bundles
     */
    public BundleAccessors getBundles() {
        return baccForBundleAccessors;
    }

    /**
     * Returns the group of plugins at plugins
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    public static class ComLibraryAccessors extends SubDependencyFactory {
        private final ComGithubLibraryAccessors laccForComGithubLibraryAccessors = new ComGithubLibraryAccessors(owner);
        private final ComGoogleLibraryAccessors laccForComGoogleLibraryAccessors = new ComGoogleLibraryAccessors(owner);

        public ComLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.github
         */
        public ComGithubLibraryAccessors getGithub() {
            return laccForComGithubLibraryAccessors;
        }

        /**
         * Returns the group of libraries at com.google
         */
        public ComGoogleLibraryAccessors getGoogle() {
            return laccForComGoogleLibraryAccessors;
        }

    }

    public static class ComGithubLibraryAccessors extends SubDependencyFactory {
        private final ComGithubUlisesbocchioLibraryAccessors laccForComGithubUlisesbocchioLibraryAccessors = new ComGithubUlisesbocchioLibraryAccessors(owner);

        public ComGithubLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.github.ulisesbocchio
         */
        public ComGithubUlisesbocchioLibraryAccessors getUlisesbocchio() {
            return laccForComGithubUlisesbocchioLibraryAccessors;
        }

    }

    public static class ComGithubUlisesbocchioLibraryAccessors extends SubDependencyFactory {
        private final ComGithubUlisesbocchioJasyptLibraryAccessors laccForComGithubUlisesbocchioJasyptLibraryAccessors = new ComGithubUlisesbocchioJasyptLibraryAccessors(owner);

        public ComGithubUlisesbocchioLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.github.ulisesbocchio.jasypt
         */
        public ComGithubUlisesbocchioJasyptLibraryAccessors getJasypt() {
            return laccForComGithubUlisesbocchioJasyptLibraryAccessors;
        }

    }

    public static class ComGithubUlisesbocchioJasyptLibraryAccessors extends SubDependencyFactory {
        private final ComGithubUlisesbocchioJasyptSpringLibraryAccessors laccForComGithubUlisesbocchioJasyptSpringLibraryAccessors = new ComGithubUlisesbocchioJasyptSpringLibraryAccessors(owner);

        public ComGithubUlisesbocchioJasyptLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.github.ulisesbocchio.jasypt.spring
         */
        public ComGithubUlisesbocchioJasyptSpringLibraryAccessors getSpring() {
            return laccForComGithubUlisesbocchioJasyptSpringLibraryAccessors;
        }

    }

    public static class ComGithubUlisesbocchioJasyptSpringLibraryAccessors extends SubDependencyFactory {
        private final ComGithubUlisesbocchioJasyptSpringBootLibraryAccessors laccForComGithubUlisesbocchioJasyptSpringBootLibraryAccessors = new ComGithubUlisesbocchioJasyptSpringBootLibraryAccessors(owner);

        public ComGithubUlisesbocchioJasyptSpringLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.github.ulisesbocchio.jasypt.spring.boot
         */
        public ComGithubUlisesbocchioJasyptSpringBootLibraryAccessors getBoot() {
            return laccForComGithubUlisesbocchioJasyptSpringBootLibraryAccessors;
        }

    }

    public static class ComGithubUlisesbocchioJasyptSpringBootLibraryAccessors extends SubDependencyFactory {

        public ComGithubUlisesbocchioJasyptSpringBootLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for starter (com.github.ulisesbocchio:jasypt-spring-boot-starter)
         * with versionRef 'com.github.ulisesbocchio.jasypt.spring.boot.starter'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getStarter() {
                return create("com.github.ulisesbocchio.jasypt.spring.boot.starter");
        }

    }

    public static class ComGoogleLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleCodeLibraryAccessors laccForComGoogleCodeLibraryAccessors = new ComGoogleCodeLibraryAccessors(owner);

        public ComGoogleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.google.code
         */
        public ComGoogleCodeLibraryAccessors getCode() {
            return laccForComGoogleCodeLibraryAccessors;
        }

    }

    public static class ComGoogleCodeLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleCodeGsonLibraryAccessors laccForComGoogleCodeGsonLibraryAccessors = new ComGoogleCodeGsonLibraryAccessors(owner);

        public ComGoogleCodeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.google.code.gson
         */
        public ComGoogleCodeGsonLibraryAccessors getGson() {
            return laccForComGoogleCodeGsonLibraryAccessors;
        }

    }

    public static class ComGoogleCodeGsonLibraryAccessors extends SubDependencyFactory {

        public ComGoogleCodeGsonLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for gson (com.google.code.gson:gson)
         * with versionRef 'com.google.code.gson.gson'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getGson() {
                return create("com.google.code.gson.gson");
        }

    }

    public static class OrgLibraryAccessors extends SubDependencyFactory {
        private final OrgMariadbLibraryAccessors laccForOrgMariadbLibraryAccessors = new OrgMariadbLibraryAccessors(owner);
        private final OrgProjectlombokLibraryAccessors laccForOrgProjectlombokLibraryAccessors = new OrgProjectlombokLibraryAccessors(owner);
        private final OrgSpringdocLibraryAccessors laccForOrgSpringdocLibraryAccessors = new OrgSpringdocLibraryAccessors(owner);
        private final OrgSpringframeworkLibraryAccessors laccForOrgSpringframeworkLibraryAccessors = new OrgSpringframeworkLibraryAccessors(owner);

        public OrgLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.mariadb
         */
        public OrgMariadbLibraryAccessors getMariadb() {
            return laccForOrgMariadbLibraryAccessors;
        }

        /**
         * Returns the group of libraries at org.projectlombok
         */
        public OrgProjectlombokLibraryAccessors getProjectlombok() {
            return laccForOrgProjectlombokLibraryAccessors;
        }

        /**
         * Returns the group of libraries at org.springdoc
         */
        public OrgSpringdocLibraryAccessors getSpringdoc() {
            return laccForOrgSpringdocLibraryAccessors;
        }

        /**
         * Returns the group of libraries at org.springframework
         */
        public OrgSpringframeworkLibraryAccessors getSpringframework() {
            return laccForOrgSpringframeworkLibraryAccessors;
        }

    }

    public static class OrgMariadbLibraryAccessors extends SubDependencyFactory {
        private final OrgMariadbJdbcLibraryAccessors laccForOrgMariadbJdbcLibraryAccessors = new OrgMariadbJdbcLibraryAccessors(owner);

        public OrgMariadbLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.mariadb.jdbc
         */
        public OrgMariadbJdbcLibraryAccessors getJdbc() {
            return laccForOrgMariadbJdbcLibraryAccessors;
        }

    }

    public static class OrgMariadbJdbcLibraryAccessors extends SubDependencyFactory {
        private final OrgMariadbJdbcMariadbLibraryAccessors laccForOrgMariadbJdbcMariadbLibraryAccessors = new OrgMariadbJdbcMariadbLibraryAccessors(owner);

        public OrgMariadbJdbcLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.mariadb.jdbc.mariadb
         */
        public OrgMariadbJdbcMariadbLibraryAccessors getMariadb() {
            return laccForOrgMariadbJdbcMariadbLibraryAccessors;
        }

    }

    public static class OrgMariadbJdbcMariadbLibraryAccessors extends SubDependencyFactory {
        private final OrgMariadbJdbcMariadbJavaLibraryAccessors laccForOrgMariadbJdbcMariadbJavaLibraryAccessors = new OrgMariadbJdbcMariadbJavaLibraryAccessors(owner);

        public OrgMariadbJdbcMariadbLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.mariadb.jdbc.mariadb.java
         */
        public OrgMariadbJdbcMariadbJavaLibraryAccessors getJava() {
            return laccForOrgMariadbJdbcMariadbJavaLibraryAccessors;
        }

    }

    public static class OrgMariadbJdbcMariadbJavaLibraryAccessors extends SubDependencyFactory {

        public OrgMariadbJdbcMariadbJavaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for client (org.mariadb.jdbc:mariadb-java-client)
         * with versionRef 'org.mariadb.jdbc.mariadb.java.client'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getClient() {
                return create("org.mariadb.jdbc.mariadb.java.client");
        }

    }

    public static class OrgProjectlombokLibraryAccessors extends SubDependencyFactory {

        public OrgProjectlombokLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for lombok (org.projectlombok:lombok)
         * with versionRef 'org.projectlombok.lombok'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getLombok() {
                return create("org.projectlombok.lombok");
        }

    }

    public static class OrgSpringdocLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringdocSpringdocLibraryAccessors laccForOrgSpringdocSpringdocLibraryAccessors = new OrgSpringdocSpringdocLibraryAccessors(owner);

        public OrgSpringdocLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.springdoc.springdoc
         */
        public OrgSpringdocSpringdocLibraryAccessors getSpringdoc() {
            return laccForOrgSpringdocSpringdocLibraryAccessors;
        }

    }

    public static class OrgSpringdocSpringdocLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringdocSpringdocOpenapiLibraryAccessors laccForOrgSpringdocSpringdocOpenapiLibraryAccessors = new OrgSpringdocSpringdocOpenapiLibraryAccessors(owner);

        public OrgSpringdocSpringdocLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.springdoc.springdoc.openapi
         */
        public OrgSpringdocSpringdocOpenapiLibraryAccessors getOpenapi() {
            return laccForOrgSpringdocSpringdocOpenapiLibraryAccessors;
        }

    }

    public static class OrgSpringdocSpringdocOpenapiLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringdocSpringdocOpenapiStarterLibraryAccessors laccForOrgSpringdocSpringdocOpenapiStarterLibraryAccessors = new OrgSpringdocSpringdocOpenapiStarterLibraryAccessors(owner);

        public OrgSpringdocSpringdocOpenapiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.springdoc.springdoc.openapi.starter
         */
        public OrgSpringdocSpringdocOpenapiStarterLibraryAccessors getStarter() {
            return laccForOrgSpringdocSpringdocOpenapiStarterLibraryAccessors;
        }

    }

    public static class OrgSpringdocSpringdocOpenapiStarterLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringdocSpringdocOpenapiStarterWebmvcLibraryAccessors laccForOrgSpringdocSpringdocOpenapiStarterWebmvcLibraryAccessors = new OrgSpringdocSpringdocOpenapiStarterWebmvcLibraryAccessors(owner);

        public OrgSpringdocSpringdocOpenapiStarterLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.springdoc.springdoc.openapi.starter.webmvc
         */
        public OrgSpringdocSpringdocOpenapiStarterWebmvcLibraryAccessors getWebmvc() {
            return laccForOrgSpringdocSpringdocOpenapiStarterWebmvcLibraryAccessors;
        }

    }

    public static class OrgSpringdocSpringdocOpenapiStarterWebmvcLibraryAccessors extends SubDependencyFactory {

        public OrgSpringdocSpringdocOpenapiStarterWebmvcLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for ui (org.springdoc:springdoc-openapi-starter-webmvc-ui)
         * with versionRef 'org.springdoc.springdoc.openapi.starter.webmvc.ui'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getUi() {
                return create("org.springdoc.springdoc.openapi.starter.webmvc.ui");
        }

    }

    public static class OrgSpringframeworkLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootLibraryAccessors laccForOrgSpringframeworkBootLibraryAccessors = new OrgSpringframeworkBootLibraryAccessors(owner);

        public OrgSpringframeworkLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.springframework.boot
         */
        public OrgSpringframeworkBootLibraryAccessors getBoot() {
            return laccForOrgSpringframeworkBootLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBootLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootSpringLibraryAccessors laccForOrgSpringframeworkBootSpringLibraryAccessors = new OrgSpringframeworkBootSpringLibraryAccessors(owner);

        public OrgSpringframeworkBootLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.springframework.boot.spring
         */
        public OrgSpringframeworkBootSpringLibraryAccessors getSpring() {
            return laccForOrgSpringframeworkBootSpringLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootSpringBootLibraryAccessors laccForOrgSpringframeworkBootSpringBootLibraryAccessors = new OrgSpringframeworkBootSpringBootLibraryAccessors(owner);

        public OrgSpringframeworkBootSpringLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.springframework.boot.spring.boot
         */
        public OrgSpringframeworkBootSpringBootLibraryAccessors getBoot() {
            return laccForOrgSpringframeworkBootSpringBootLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootSpringBootConfigurationLibraryAccessors laccForOrgSpringframeworkBootSpringBootConfigurationLibraryAccessors = new OrgSpringframeworkBootSpringBootConfigurationLibraryAccessors(owner);
        private final OrgSpringframeworkBootSpringBootStarterLibraryAccessors laccForOrgSpringframeworkBootSpringBootStarterLibraryAccessors = new OrgSpringframeworkBootSpringBootStarterLibraryAccessors(owner);

        public OrgSpringframeworkBootSpringBootLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for devtools (org.springframework.boot:spring-boot-devtools)
         * with versionRef 'org.springframework.boot.spring.boot.devtools'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getDevtools() {
                return create("org.springframework.boot.spring.boot.devtools");
        }

        /**
         * Returns the group of libraries at org.springframework.boot.spring.boot.configuration
         */
        public OrgSpringframeworkBootSpringBootConfigurationLibraryAccessors getConfiguration() {
            return laccForOrgSpringframeworkBootSpringBootConfigurationLibraryAccessors;
        }

        /**
         * Returns the group of libraries at org.springframework.boot.spring.boot.starter
         */
        public OrgSpringframeworkBootSpringBootStarterLibraryAccessors getStarter() {
            return laccForOrgSpringframeworkBootSpringBootStarterLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootConfigurationLibraryAccessors extends SubDependencyFactory {

        public OrgSpringframeworkBootSpringBootConfigurationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for processor (org.springframework.boot:spring-boot-configuration-processor)
         * with versionRef 'org.springframework.boot.spring.boot.configuration.processor'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getProcessor() {
                return create("org.springframework.boot.spring.boot.configuration.processor");
        }

    }

    public static class OrgSpringframeworkBootSpringBootStarterLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootSpringBootStarterDataLibraryAccessors laccForOrgSpringframeworkBootSpringBootStarterDataLibraryAccessors = new OrgSpringframeworkBootSpringBootStarterDataLibraryAccessors(owner);

        public OrgSpringframeworkBootSpringBootStarterLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for jdbc (org.springframework.boot:spring-boot-starter-jdbc)
         * with versionRef 'org.springframework.boot.spring.boot.starter.jdbc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJdbc() {
                return create("org.springframework.boot.spring.boot.starter.jdbc");
        }

            /**
             * Creates a dependency provider for test (org.springframework.boot:spring-boot-starter-test)
         * with versionRef 'org.springframework.boot.spring.boot.starter.test'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getTest() {
                return create("org.springframework.boot.spring.boot.starter.test");
        }

            /**
             * Creates a dependency provider for validation (org.springframework.boot:spring-boot-starter-validation)
         * with versionRef 'org.springframework.boot.spring.boot.starter.validation'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getValidation() {
                return create("org.springframework.boot.spring.boot.starter.validation");
        }

            /**
             * Creates a dependency provider for web (org.springframework.boot:spring-boot-starter-web)
         * with versionRef 'org.springframework.boot.spring.boot.starter.web'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getWeb() {
                return create("org.springframework.boot.spring.boot.starter.web");
        }

        /**
         * Returns the group of libraries at org.springframework.boot.spring.boot.starter.data
         */
        public OrgSpringframeworkBootSpringBootStarterDataLibraryAccessors getData() {
            return laccForOrgSpringframeworkBootSpringBootStarterDataLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootStarterDataLibraryAccessors extends SubDependencyFactory {

        public OrgSpringframeworkBootSpringBootStarterDataLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for jpa (org.springframework.boot:spring-boot-starter-data-jpa)
         * with versionRef 'org.springframework.boot.spring.boot.starter.data.jpa'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJpa() {
                return create("org.springframework.boot.spring.boot.starter.data.jpa");
        }

            /**
             * Creates a dependency provider for redis (org.springframework.boot:spring-boot-starter-data-redis)
         * with versionRef 'org.springframework.boot.spring.boot.starter.data.redis'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getRedis() {
                return create("org.springframework.boot.spring.boot.starter.data.redis");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final ComVersionAccessors vaccForComVersionAccessors = new ComVersionAccessors(providers, config);
        private final OrgVersionAccessors vaccForOrgVersionAccessors = new OrgVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com
         */
        public ComVersionAccessors getCom() {
            return vaccForComVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org
         */
        public OrgVersionAccessors getOrg() {
            return vaccForOrgVersionAccessors;
        }

    }

    public static class ComVersionAccessors extends VersionFactory  {

        private final ComGithubVersionAccessors vaccForComGithubVersionAccessors = new ComGithubVersionAccessors(providers, config);
        private final ComGoogleVersionAccessors vaccForComGoogleVersionAccessors = new ComGoogleVersionAccessors(providers, config);
        public ComVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com.github
         */
        public ComGithubVersionAccessors getGithub() {
            return vaccForComGithubVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.com.google
         */
        public ComGoogleVersionAccessors getGoogle() {
            return vaccForComGoogleVersionAccessors;
        }

    }

    public static class ComGithubVersionAccessors extends VersionFactory  {

        private final ComGithubUlisesbocchioVersionAccessors vaccForComGithubUlisesbocchioVersionAccessors = new ComGithubUlisesbocchioVersionAccessors(providers, config);
        public ComGithubVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com.github.ulisesbocchio
         */
        public ComGithubUlisesbocchioVersionAccessors getUlisesbocchio() {
            return vaccForComGithubUlisesbocchioVersionAccessors;
        }

    }

    public static class ComGithubUlisesbocchioVersionAccessors extends VersionFactory  {

        private final ComGithubUlisesbocchioJasyptVersionAccessors vaccForComGithubUlisesbocchioJasyptVersionAccessors = new ComGithubUlisesbocchioJasyptVersionAccessors(providers, config);
        public ComGithubUlisesbocchioVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com.github.ulisesbocchio.jasypt
         */
        public ComGithubUlisesbocchioJasyptVersionAccessors getJasypt() {
            return vaccForComGithubUlisesbocchioJasyptVersionAccessors;
        }

    }

    public static class ComGithubUlisesbocchioJasyptVersionAccessors extends VersionFactory  {

        private final ComGithubUlisesbocchioJasyptSpringVersionAccessors vaccForComGithubUlisesbocchioJasyptSpringVersionAccessors = new ComGithubUlisesbocchioJasyptSpringVersionAccessors(providers, config);
        public ComGithubUlisesbocchioJasyptVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com.github.ulisesbocchio.jasypt.spring
         */
        public ComGithubUlisesbocchioJasyptSpringVersionAccessors getSpring() {
            return vaccForComGithubUlisesbocchioJasyptSpringVersionAccessors;
        }

    }

    public static class ComGithubUlisesbocchioJasyptSpringVersionAccessors extends VersionFactory  {

        private final ComGithubUlisesbocchioJasyptSpringBootVersionAccessors vaccForComGithubUlisesbocchioJasyptSpringBootVersionAccessors = new ComGithubUlisesbocchioJasyptSpringBootVersionAccessors(providers, config);
        public ComGithubUlisesbocchioJasyptSpringVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com.github.ulisesbocchio.jasypt.spring.boot
         */
        public ComGithubUlisesbocchioJasyptSpringBootVersionAccessors getBoot() {
            return vaccForComGithubUlisesbocchioJasyptSpringBootVersionAccessors;
        }

    }

    public static class ComGithubUlisesbocchioJasyptSpringBootVersionAccessors extends VersionFactory  {

        public ComGithubUlisesbocchioJasyptSpringBootVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: com.github.ulisesbocchio.jasypt.spring.boot.starter (3.0.5)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getStarter() { return getVersion("com.github.ulisesbocchio.jasypt.spring.boot.starter"); }

    }

    public static class ComGoogleVersionAccessors extends VersionFactory  {

        private final ComGoogleCodeVersionAccessors vaccForComGoogleCodeVersionAccessors = new ComGoogleCodeVersionAccessors(providers, config);
        public ComGoogleVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com.google.code
         */
        public ComGoogleCodeVersionAccessors getCode() {
            return vaccForComGoogleCodeVersionAccessors;
        }

    }

    public static class ComGoogleCodeVersionAccessors extends VersionFactory  {

        private final ComGoogleCodeGsonVersionAccessors vaccForComGoogleCodeGsonVersionAccessors = new ComGoogleCodeGsonVersionAccessors(providers, config);
        public ComGoogleCodeVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com.google.code.gson
         */
        public ComGoogleCodeGsonVersionAccessors getGson() {
            return vaccForComGoogleCodeGsonVersionAccessors;
        }

    }

    public static class ComGoogleCodeGsonVersionAccessors extends VersionFactory  {

        public ComGoogleCodeGsonVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: com.google.code.gson.gson (2.10.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getGson() { return getVersion("com.google.code.gson.gson"); }

    }

    public static class OrgVersionAccessors extends VersionFactory  {

        private final OrgMariadbVersionAccessors vaccForOrgMariadbVersionAccessors = new OrgMariadbVersionAccessors(providers, config);
        private final OrgProjectlombokVersionAccessors vaccForOrgProjectlombokVersionAccessors = new OrgProjectlombokVersionAccessors(providers, config);
        private final OrgSpringdocVersionAccessors vaccForOrgSpringdocVersionAccessors = new OrgSpringdocVersionAccessors(providers, config);
        private final OrgSpringframeworkVersionAccessors vaccForOrgSpringframeworkVersionAccessors = new OrgSpringframeworkVersionAccessors(providers, config);
        public OrgVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.mariadb
         */
        public OrgMariadbVersionAccessors getMariadb() {
            return vaccForOrgMariadbVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org.projectlombok
         */
        public OrgProjectlombokVersionAccessors getProjectlombok() {
            return vaccForOrgProjectlombokVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org.springdoc
         */
        public OrgSpringdocVersionAccessors getSpringdoc() {
            return vaccForOrgSpringdocVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org.springframework
         */
        public OrgSpringframeworkVersionAccessors getSpringframework() {
            return vaccForOrgSpringframeworkVersionAccessors;
        }

    }

    public static class OrgMariadbVersionAccessors extends VersionFactory  {

        private final OrgMariadbJdbcVersionAccessors vaccForOrgMariadbJdbcVersionAccessors = new OrgMariadbJdbcVersionAccessors(providers, config);
        public OrgMariadbVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.mariadb.jdbc
         */
        public OrgMariadbJdbcVersionAccessors getJdbc() {
            return vaccForOrgMariadbJdbcVersionAccessors;
        }

    }

    public static class OrgMariadbJdbcVersionAccessors extends VersionFactory  {

        private final OrgMariadbJdbcMariadbVersionAccessors vaccForOrgMariadbJdbcMariadbVersionAccessors = new OrgMariadbJdbcMariadbVersionAccessors(providers, config);
        public OrgMariadbJdbcVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.mariadb.jdbc.mariadb
         */
        public OrgMariadbJdbcMariadbVersionAccessors getMariadb() {
            return vaccForOrgMariadbJdbcMariadbVersionAccessors;
        }

    }

    public static class OrgMariadbJdbcMariadbVersionAccessors extends VersionFactory  {

        private final OrgMariadbJdbcMariadbJavaVersionAccessors vaccForOrgMariadbJdbcMariadbJavaVersionAccessors = new OrgMariadbJdbcMariadbJavaVersionAccessors(providers, config);
        public OrgMariadbJdbcMariadbVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.mariadb.jdbc.mariadb.java
         */
        public OrgMariadbJdbcMariadbJavaVersionAccessors getJava() {
            return vaccForOrgMariadbJdbcMariadbJavaVersionAccessors;
        }

    }

    public static class OrgMariadbJdbcMariadbJavaVersionAccessors extends VersionFactory  {

        public OrgMariadbJdbcMariadbJavaVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.mariadb.jdbc.mariadb.java.client (3.2.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getClient() { return getVersion("org.mariadb.jdbc.mariadb.java.client"); }

    }

    public static class OrgProjectlombokVersionAccessors extends VersionFactory  {

        public OrgProjectlombokVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.projectlombok.lombok (1.18.30)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getLombok() { return getVersion("org.projectlombok.lombok"); }

    }

    public static class OrgSpringdocVersionAccessors extends VersionFactory  {

        private final OrgSpringdocSpringdocVersionAccessors vaccForOrgSpringdocSpringdocVersionAccessors = new OrgSpringdocSpringdocVersionAccessors(providers, config);
        public OrgSpringdocVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.springdoc.springdoc
         */
        public OrgSpringdocSpringdocVersionAccessors getSpringdoc() {
            return vaccForOrgSpringdocSpringdocVersionAccessors;
        }

    }

    public static class OrgSpringdocSpringdocVersionAccessors extends VersionFactory  {

        private final OrgSpringdocSpringdocOpenapiVersionAccessors vaccForOrgSpringdocSpringdocOpenapiVersionAccessors = new OrgSpringdocSpringdocOpenapiVersionAccessors(providers, config);
        public OrgSpringdocSpringdocVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.springdoc.springdoc.openapi
         */
        public OrgSpringdocSpringdocOpenapiVersionAccessors getOpenapi() {
            return vaccForOrgSpringdocSpringdocOpenapiVersionAccessors;
        }

    }

    public static class OrgSpringdocSpringdocOpenapiVersionAccessors extends VersionFactory  {

        private final OrgSpringdocSpringdocOpenapiStarterVersionAccessors vaccForOrgSpringdocSpringdocOpenapiStarterVersionAccessors = new OrgSpringdocSpringdocOpenapiStarterVersionAccessors(providers, config);
        public OrgSpringdocSpringdocOpenapiVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.springdoc.springdoc.openapi.starter
         */
        public OrgSpringdocSpringdocOpenapiStarterVersionAccessors getStarter() {
            return vaccForOrgSpringdocSpringdocOpenapiStarterVersionAccessors;
        }

    }

    public static class OrgSpringdocSpringdocOpenapiStarterVersionAccessors extends VersionFactory  {

        private final OrgSpringdocSpringdocOpenapiStarterWebmvcVersionAccessors vaccForOrgSpringdocSpringdocOpenapiStarterWebmvcVersionAccessors = new OrgSpringdocSpringdocOpenapiStarterWebmvcVersionAccessors(providers, config);
        public OrgSpringdocSpringdocOpenapiStarterVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.springdoc.springdoc.openapi.starter.webmvc
         */
        public OrgSpringdocSpringdocOpenapiStarterWebmvcVersionAccessors getWebmvc() {
            return vaccForOrgSpringdocSpringdocOpenapiStarterWebmvcVersionAccessors;
        }

    }

    public static class OrgSpringdocSpringdocOpenapiStarterWebmvcVersionAccessors extends VersionFactory  {

        public OrgSpringdocSpringdocOpenapiStarterWebmvcVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.springdoc.springdoc.openapi.starter.webmvc.ui (2.0.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getUi() { return getVersion("org.springdoc.springdoc.openapi.starter.webmvc.ui"); }

    }

    public static class OrgSpringframeworkVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkBootVersionAccessors vaccForOrgSpringframeworkBootVersionAccessors = new OrgSpringframeworkBootVersionAccessors(providers, config);
        public OrgSpringframeworkVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.springframework.boot
         */
        public OrgSpringframeworkBootVersionAccessors getBoot() {
            return vaccForOrgSpringframeworkBootVersionAccessors;
        }

    }

    public static class OrgSpringframeworkBootVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkBootSpringVersionAccessors vaccForOrgSpringframeworkBootSpringVersionAccessors = new OrgSpringframeworkBootSpringVersionAccessors(providers, config);
        public OrgSpringframeworkBootVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.springframework.boot.spring
         */
        public OrgSpringframeworkBootSpringVersionAccessors getSpring() {
            return vaccForOrgSpringframeworkBootSpringVersionAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkBootSpringBootVersionAccessors vaccForOrgSpringframeworkBootSpringBootVersionAccessors = new OrgSpringframeworkBootSpringBootVersionAccessors(providers, config);
        public OrgSpringframeworkBootSpringVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.springframework.boot.spring.boot
         */
        public OrgSpringframeworkBootSpringBootVersionAccessors getBoot() {
            return vaccForOrgSpringframeworkBootSpringBootVersionAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkBootSpringBootConfigurationVersionAccessors vaccForOrgSpringframeworkBootSpringBootConfigurationVersionAccessors = new OrgSpringframeworkBootSpringBootConfigurationVersionAccessors(providers, config);
        private final OrgSpringframeworkBootSpringBootStarterVersionAccessors vaccForOrgSpringframeworkBootSpringBootStarterVersionAccessors = new OrgSpringframeworkBootSpringBootStarterVersionAccessors(providers, config);
        public OrgSpringframeworkBootSpringBootVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.springframework.boot.spring.boot.devtools (3.2.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getDevtools() { return getVersion("org.springframework.boot.spring.boot.devtools"); }

        /**
         * Returns the group of versions at versions.org.springframework.boot.spring.boot.configuration
         */
        public OrgSpringframeworkBootSpringBootConfigurationVersionAccessors getConfiguration() {
            return vaccForOrgSpringframeworkBootSpringBootConfigurationVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org.springframework.boot.spring.boot.starter
         */
        public OrgSpringframeworkBootSpringBootStarterVersionAccessors getStarter() {
            return vaccForOrgSpringframeworkBootSpringBootStarterVersionAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootConfigurationVersionAccessors extends VersionFactory  {

        public OrgSpringframeworkBootSpringBootConfigurationVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.springframework.boot.spring.boot.configuration.processor (3.2.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getProcessor() { return getVersion("org.springframework.boot.spring.boot.configuration.processor"); }

    }

    public static class OrgSpringframeworkBootSpringBootStarterVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkBootSpringBootStarterDataVersionAccessors vaccForOrgSpringframeworkBootSpringBootStarterDataVersionAccessors = new OrgSpringframeworkBootSpringBootStarterDataVersionAccessors(providers, config);
        public OrgSpringframeworkBootSpringBootStarterVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.springframework.boot.spring.boot.starter.jdbc (3.2.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJdbc() { return getVersion("org.springframework.boot.spring.boot.starter.jdbc"); }

            /**
             * Returns the version associated to this alias: org.springframework.boot.spring.boot.starter.test (3.2.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getTest() { return getVersion("org.springframework.boot.spring.boot.starter.test"); }

            /**
             * Returns the version associated to this alias: org.springframework.boot.spring.boot.starter.validation (3.2.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getValidation() { return getVersion("org.springframework.boot.spring.boot.starter.validation"); }

            /**
             * Returns the version associated to this alias: org.springframework.boot.spring.boot.starter.web (3.2.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getWeb() { return getVersion("org.springframework.boot.spring.boot.starter.web"); }

        /**
         * Returns the group of versions at versions.org.springframework.boot.spring.boot.starter.data
         */
        public OrgSpringframeworkBootSpringBootStarterDataVersionAccessors getData() {
            return vaccForOrgSpringframeworkBootSpringBootStarterDataVersionAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootStarterDataVersionAccessors extends VersionFactory  {

        public OrgSpringframeworkBootSpringBootStarterDataVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.springframework.boot.spring.boot.starter.data.jpa (3.2.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJpa() { return getVersion("org.springframework.boot.spring.boot.starter.data.jpa"); }

            /**
             * Returns the version associated to this alias: org.springframework.boot.spring.boot.starter.data.redis (3.2.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getRedis() { return getVersion("org.springframework.boot.spring.boot.starter.data.redis"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

}

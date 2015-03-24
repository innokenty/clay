package ru.qatools.clay.maven.settings;

import org.apache.maven.model.*;

/**
 * This elements describes all that pertains to distribution for a
 * project. It is primarily used for deployment of artifacts
 * and the site produced by the build.
 *
 * @author Innokenty Shuvalov innokenty@yandex-team.ru
 */
@SuppressWarnings("JavaDoc")
public class FluentDistributionManagementBuilder {

    private final DistributionManagement management;

    private FluentDistributionManagementBuilder(DistributionManagement management) {
        this.management = management;
    }

    /**
     * This elements describes all that pertains to distribution for a
     * project. It is primarily used for deployment of artifacts
     * and the site produced by the build.
     */
    public static FluentDistributionManagementBuilder newDistributionManagement() {
        return new FluentDistributionManagementBuilder(new DistributionManagement());
    }

    public DistributionManagement build() {
        return management;
    }

    /* DELEGATED METHODS */

    /**
     * Set the URL of the project's download page. If not given
     * users will be referred to the homepage given by
     * <code>url</code>. This is given to assist in
     * locating artifacts that are not in the repository
     * due to licensing restrictions.
     *
     * @param downloadUrl
     */
    public FluentDistributionManagementBuilder withDownloadUrl(String downloadUrl) {
        management.setDownloadUrl(downloadUrl);
        return this;
    }

    public FluentDistributionManagementBuilder withLocation(Object key, FluentInputLocationBuilder location) {
        return withLocation(key, location.build());
    }

    public FluentDistributionManagementBuilder withLocation(Object key, InputLocation location) {
        management.setLocation(key, location);
        return this;
    }

    /**
     * Set relocation information of the artifact if it has been
     * moved to a new group ID and/or artifact ID.
     *
     * @param relocation
     */
    public FluentDistributionManagementBuilder withRelocation(FluentRelocationBuilder relocation) {
        return withRelocation(relocation.build());
    }

    /**
     * Set relocation information of the artifact if it has been
     * moved to a new group ID and/or artifact ID.
     *
     * @param relocation
     */
    public FluentDistributionManagementBuilder withRelocation(Relocation relocation) {
        management.setRelocation(relocation);
        return this;
    }

    /**
     * Set information needed for deploying the web site of the
     * project.
     *
     * @param site
     */
    public FluentDistributionManagementBuilder withSite(FluentSiteBuilder site) {
        return withSite(site.build());
    }

    /**
     * Set information needed for deploying the web site of the
     * project.
     *
     * @param site
     */
    public FluentDistributionManagementBuilder withSite(Site site) {
        management.setSite(site);
        return this;
    }

    /**
     * Set information needed to deploy the artifacts generated by
     * the project to a remote repository.
     *
     * @param repository
     */
    public FluentDistributionManagementBuilder withRepository(FluentDeploymentRepositoryBuilder repository) {
        return withRepository(repository.build());
    }

    /**
     * Set information needed to deploy the artifacts generated by
     * the project to a remote repository.
     *
     * @param repository
     */
    public FluentDistributionManagementBuilder withRepository(DeploymentRepository repository) {
        management.setRepository(repository);
        return this;
    }

    /**
     * Set where to deploy snapshots of artifacts to. If not given,
     * it defaults to the <code>repository</code> element.
     *
     * @param repository
     */
    public FluentDistributionManagementBuilder withSnapshotRepository(FluentDeploymentRepositoryBuilder repository) {
        return withSnapshotRepository(repository.build());
    }

    /**
     * Set where to deploy snapshots of artifacts to. If not given,
     * it defaults to the <code>repository</code> element.
     *
     * @param repository
     */
    public FluentDistributionManagementBuilder withSnapshotRepository(DeploymentRepository repository) {
        management.setSnapshotRepository(repository);
        return this;
    }

    /**
     * Set gives the status of this artifact in the remote
     * repository. This must not be set in your local project, as
     * it is updated by tools placing it in the repository.
     * Valid values are: <code>none</code> (default),
     * <code>converted</code> (repository manager converted this
     * from an Maven 1 POM), <code>partner</code> (directly synced
     * from a partner Maven 2 repository), <code>deployed</code>
     * (was deployed from a Maven 2 instance), <code>verified</code>
     * (has been hand verified as correct and final).
     *
     * @param status
     */
    public FluentDistributionManagementBuilder withStatus(String status) {
        management.setStatus(status);
        return this;
    }
}
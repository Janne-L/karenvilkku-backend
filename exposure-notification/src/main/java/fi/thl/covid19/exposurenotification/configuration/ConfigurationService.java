package fi.thl.covid19.exposurenotification.configuration;

import fi.thl.covid19.exposurenotification.configuration.v1.AppConfiguration;
import fi.thl.covid19.exposurenotification.configuration.v1.ExposureConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static java.util.Objects.requireNonNull;

@Service
public class ConfigurationService {

    private static final Logger LOG = LoggerFactory.getLogger(ConfigurationService.class);

    private final ConfigurationDao dao;

    public ConfigurationService(ConfigurationDao dao) {
        this.dao = requireNonNull(dao);
        LOG.info("Initialized");
    }

    public ExposureConfiguration getLatestExposureConfig() {
        return dao.getLatestExposureConfiguration();
    }

    public AppConfiguration getLatestAppConfig() {
        return AppConfiguration.DEFAULT;
    }
}

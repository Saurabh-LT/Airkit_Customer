package com.resumelibrary.utilities;

import java.io.ByteArrayOutputStream;

public class FailedScenarioPojo {

    public String getScenarioName() {
        return scenarioName;
    }

    public void setScenarioName(String scenarioName) {
        this.scenarioName = scenarioName;
    }

    public String getTagDetails() {
        return tagDetails;
    }

    public void setTagDetails(String tagDetails) {
        this.tagDetails = tagDetails;
    }

    public String getFailedReason() {
        return failedReason;
    }

    public void setFailedReason(String failedReason) {
        this.failedReason = failedReason;
    }

    private String scenarioName;
    private String tagDetails;
    private String failedReason;

    public String getStepDescription() {
        return stepDescription;
    }

    public void setStepDescription(String stepDescription) {
        this.stepDescription = stepDescription;
    }

    private String stepDescription;

    public void setBaos(ByteArrayOutputStream baos) {
        this.baos = baos;
    }

    private ByteArrayOutputStream baos;

    public ByteArrayOutputStream getBaos() {
        return baos;
    }
}

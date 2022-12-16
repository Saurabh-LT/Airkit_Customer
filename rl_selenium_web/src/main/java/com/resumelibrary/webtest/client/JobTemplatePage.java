package com.resumelibrary.webtest.client;

import com.resumelibrary.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JobTemplatePage extends Utility {

    public JobTemplatePage()
    {
        PageFactory.initElements(getThreadDriver(),this);
    }
    private static final Logger logger = LogManager.getLogger(JobTemplatePage.class);

    @FindBy(id = "salary_description")
    WebElement SalaryDescription;
    @FindBy(xpath = "//*[@id=\"cke_1_contents\"]/div")
    WebElement JobDescription;
    @FindBy(id = "preview-close-btn")
    WebElement PreviewCloseBtn;
    @FindBy(id = "template_name")
    WebElement TemplateName;
    @FindBy(id = "template")
    WebElement SelectTemplate;
    @FindBy(xpath = "//*[(@class='btn-sm table-action delete-btn trigger-confirm-delete')]")
    WebElement DeleteTemplateBtn;
    @FindBy(xpath = "//*[(@class='btn template-confirm-delete-btn')]")
    WebElement DeleteConfirmBtn;
    @FindBy(id = "preview_submit_btn")
    WebElement PreviewSubmitBtn;
    @FindBy(id = "save-as-template-submit")
    WebElement UpdateTemplateBtn;

    public void enterSalaryDescription(String salaryDescription) {
        logger.info("Entered Salary Description" + salaryDescription);
        clearTextFromField(SalaryDescription);
        SalaryDescription.sendKeys(salaryDescription);
    }
    public void enterTemplateName(String templateName) {
        logger.info("Entered Template Name" + templateName);
        sendTextToElement(TemplateName, templateName);
    }

    public void selectJobTemplate(String template) {
        logger.info("select the option job template as  :" + template);
        selectByVisibleText(SelectTemplate, template);
    }

    public void clickDeleteButton() {
        clickOnElement(DeleteTemplateBtn);
    }

    public void clickDeleteConfirmButton() {
        clickOnElement(DeleteConfirmBtn);
    }

    public void clickOnPreviewSubmitButton() {
        logger.info("Clicking on save template button ");
        clickOnElement(PreviewSubmitBtn);
    }

    public void clickOnUpdateTemplateButton() {
        logger.info("Clicking on save template button ");
        clickOnElement(UpdateTemplateBtn);
    }
}
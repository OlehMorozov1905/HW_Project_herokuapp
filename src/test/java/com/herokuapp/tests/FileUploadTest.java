package com.herokuapp.tests;

import com.herokuapp.pages.FileUploadPage;
import com.herokuapp.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest extends TestBase{
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getFileUploadPage();
    }
    @Test
    public void uploadFile() {
        new FileUploadPage(driver).fileUpload("C:/Tools/vincent_vega.jpg")
                .verifySuccessTitle("File Uploaded!");
    }
}

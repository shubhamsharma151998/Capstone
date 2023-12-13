import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import time
@pytest.fixture
def driver():
    # Set up the WebDriver (in this case, Chrome)
    driver = webdriver.Chrome()
    driver.maximize_window()
    url = "http://the-internet.herokuapp.com/"
    driver.get(url)
    yield driver
    #driver.quit()

def test_verify_home_page_title(driver):
    
    time.sleep(5)
    assert "The Internet" in driver.title

def test_verify_checkboxes_page(driver):
    # Step 2: Click on Checkboxes link and verify the text
    time.sleep(5)
    checkboxes_link = driver.find_element(By.LINK_TEXT, "Checkboxes")
    checkboxes_link.click()
    time.sleep(5)
    ele = driver.find_element(By.XPATH, "//div[@class='example']/h3")
    text_content = ele.text
    # WebDriverWait(driver, 10).until(EC.title_contains("Checkboxes"))
    assert text_content == "Checkboxes", "Checkboxes is not present"

    checkbox1_xpath = "(//form[@id=\"checkboxes\"]/input)[1]"
    checkbox1 = driver.find_element(By.XPATH, checkbox1_xpath)

    # Check if the checkbox is selected
    if checkbox1.is_selected():
        print("Checkbox 1 is checked.")
    else:
        print("Checkbox 1 is not checked.")

    checkbox2_xpath = "(//form[@id=\"checkboxes\"]/input)[2]"
    checkbox2 = driver.find_element(By.XPATH, checkbox1_xpath)

    # Check if the checkbox is selected
    if checkbox2.is_selected():
        print("Checkbox 2 is checked.")
    else:
        print("Checkbox 2 is not checked.")

    

def test_file_upload(driver):
    # Step 3: Navigate back to Home page
    time.sleep(5)
    file_upload_link = driver.find_element(By.LINK_TEXT, "File Upload")
    file_upload_link.click()
    time.sleep(5)
    # Step 5: Perform file upload
    choose_file_button = driver.find_element(By.ID, "file-upload")
    file_path = "C:/Users/swayam/OneDrive/Documents/SDET/Automate.txt"  # Replace with the actual file path
    choose_file_button.send_keys(file_path)
    time.sleep(5)
    upload_button = driver.find_element(By.ID, "file-submit")
    upload_button.click()
    time.sleep(5)

"""CodingBatFiller.py: Grabs all excersises from a collection and writes to a java file
Packages needed:
Selenium: pip install selenium
Pyperclip: pip install pyperclip
"""
__author__ = "Yousef Khan"

import time
from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from webdriver_manager.chrome import ChromeDriverManager
import pyperclip

# Collect preferences from user
platform = input("Windows or Mac: ")
while platform not in ["Windows", "Mac"]:
    platform = input("Please type either Windows or Mac: ")
command_key = Keys.COMMAND if platform == "Mac" else Keys.CONTROL
collection = input("Collection: ")
email = input("Email: ")
pwd = input("Password: ")

# Browser Emulator stuff
headers = {
    'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36',
    'Origin': 'https://codingbat.com/java/',
    'Accept-Language': 'en-US,en;q=0.9'

}
s = Service(ChromeDriverManager().install())
driver = webdriver.Chrome(service=s)

# Open codingbat library of the collection specified by user
driver.get(f"https://codingbat.com/java/{collection}")

time.sleep(2)

# Find the input boxes for username, password, submit, then put in the info and submit
inputs = driver.find_elements(By.TAG_NAME, 'input')
inputs[0].click()
inputs[0].send_keys(email)
inputs[1].click()
inputs[1].send_keys(pwd)
inputs[2].click()

time.sleep(2)

# Find all exercises in collection, then iterate and create a list of their links
tds = driver.find_elements(By.CSS_SELECTOR, 'td[width="200"]')
linklist = list()
for td in tds:
    linklist.append(td.find_element(By.TAG_NAME, "a").get_attribute('href').strip())

# Create/access file to write to
title = collection.split("-")[0] + collection.split("-")[1]
file = open(f"{title}.java", "a")
file.write(f"public class {title} " + "{\n")

# For each exercise, copy the code and write it to the java file
for link in linklist:
    driver.get(link)

    time.sleep(1)

    code_elem = driver.find_element(By.CSS_SELECTOR, "div#ace_div > textarea")
    code_elem.send_keys(command_key + "a")
    code_elem.send_keys(command_key + "c")
    clipboard_content = pyperclip.paste()

    file.write("\t" + clipboard_content+"\n")

# Ending stuff
file.write("\n}")
file.close()
driver.quit()

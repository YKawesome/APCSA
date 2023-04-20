from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.common.by import By
import time
from selenium.webdriver.common.keys import Keys
import pyperclip


headers = {
    'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36',
    'Origin': 'https://codingbat.com/java/',
    'Accept-Language': 'en-US,en;q=0.9'

}
collection = input("Collection: ")
email = input("Email: ")
pwd = input("Password: ")

s = Service(ChromeDriverManager().install())
driver = webdriver.Chrome(service=s)

driver.get(f"https://codingbat.com/java/{collection}")

linklist = list()

time.sleep(2)

inputs = driver.find_elements(By.TAG_NAME, 'input')

print(inputs)

inputs[0].click()
inputs[0].send_keys(email)
inputs[1].click()
inputs[1].send_keys(pwd)
inputs[2].click()

time.sleep(2)

tds = driver.find_elements(By.CSS_SELECTOR, 'td[width="200"]')

time.sleep(1)

for td in tds:
    linklist.append(td.find_element(By.TAG_NAME, "a").get_attribute('href').strip())

title = collection.split("-")[0] + collection.split("-")[1]

file = open(f"{title}.java", "a")
file.write(f"public class {title} " + "{\n")

for link in linklist:
    driver.get(link)
    time.sleep(1)

    code_elem = driver.find_element_by_css_selector("div#ace_div > textarea")
    code_elem.send_keys(Keys.COMMAND + "a")
    code_elem.send_keys(Keys.COMMAND + "c")
    clipboard_content = pyperclip.paste()

    file.write("\t" + clipboard_content+"\n")


file.write("\n}")
file.close()
driver.quit()

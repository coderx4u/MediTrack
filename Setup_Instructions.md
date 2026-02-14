## Install & Configure Java (JDK/JRE)

### 1. Install JDK 

Download the latest LTS version of Java (JDK 17 recommended):

- Oracle JDK: https://www.oracle.com/java/technologies/downloads/
![img_5.png](docs/img_5.png)


Choose your OS:
- Windows
- Mac
- Linux

---

### 2. Run Installer

Follow installation steps:
- Click on Continue
- Install
- Enter password
- Close

![img_6.png](docs/img_6.png)

---

### 3. Verify Installation 

Open terminal and run:

`java -version`

![img_7.png](docs/img_7.png)
---
### 3. Set JAVA_HOME

Setting up JAVA_HOME

`echo 'export JAVA_HOME=$(/usr/libexec/java_home -v17)' >> ~/.zshrc`

`echo 'export PATH=$JAVA_HOME/bin:$PATH' >> ~/.zshrc`

`source ~/.zshrc`

![img_9.png](docs/img_9.png)
---
### 4.Confirm Java Path

`echo $JAVA_HOME`

![img_11.png](docs/img_11.png)

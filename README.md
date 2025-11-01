# 🛒 Ecommerce Testing Project

## 🎯 Overview
This is our **Graduation Project** for the **Depi Testing Track**.  
The goal is to design and implement **Automated UI Tests** for an E-commerce website (**Swag Labs - saucedemo.com**) using **Java + Selenium WebDriver**.  

Our mission is not only to write a few test cases, but to build a **complete QA Automation Framework** that ensures:
- High coverage of critical e-commerce scenarios.
- Clear documentation and test plan.
- Continuous Integration (CI) to run tests automatically.
- Professional reporting for test results.

---

## ✨ Features of the Project
- ✅ Test Automation using **Java + Selenium**.  
- ✅ Organized framework with **Page Object Model (POM)**.  
- ✅ **TestNG** for test execution and reporting.  
- ✅ **GitHub Actions (CI/CD)** to run tests automatically on push/PR.  
- ✅ **Allure/Extent Reports** for professional reports.  
- ✅ Covers real **E-commerce workflows**:
  - Login / Logout
  - Product Browsing
  - Search & Filters
  - Add to Cart
  - Checkout (positive & negative cases)
  - User scenarios with invalid data

---

## 👨‍💻 Team Roles
- **Team Leader**: Project management, code review, GitHub repo organization.
- **Automation Engineer 1**: Java core utilities + framework base.
- **Automation Engineer 2**: Selenium locators & actions.
- **Automation Engineer 3**: Page Object Model design.
- **QA Analyst**: Writing Test Cases, documentation, reporting bugs.
- **DevOps Engineer**: CI/CD setup & reporting integration.

---

## 📂 Project Structure
```bash
ecommerce-testing-project/
│
├── src/test/java/tests/        # Test classes (organized by feature)
├── src/test/java/pages/        # Page Object classes
├── src/test/java/utils/        # Utilities (read data, helpers, waits)
├── src/test/resources/         # Test data (CSV/Excel/JSON)
├── reports/                    # Generated test reports
├── pom.xml                     # Maven dependencies
└── README.md                   # Project documentation

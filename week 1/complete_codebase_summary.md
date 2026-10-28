# ✅ Week 1 — Complete TDD Codebase (All 6 Exercises)

## Test Results

**Python (Pytest): 62/62 passed** ✅

## File Map

| Exercise | Java Test | Java Implementation | Python Test | Python Implementation |
|----------|-----------|--------------------|----|-----|
| **1. Arithmetic** | [`ArithmeticOperationsTest.java`](file:///c:/Users/Admin/Documents/Downloads/S5/DevSecOps/week%201/java/ArithmeticOperationsTest.java) | [`ArithmeticOperations.java`](file:///c:/Users/Admin/Documents/Downloads/S5/DevSecOps/week%201/java/ArithmeticOperations.java) | [`test_arithmetic_operations.py`](file:///c:/Users/Admin/Documents/Downloads/S5/DevSecOps/week%201/python/test_arithmetic_operations.py) | [`arithmetic_operations.py`](file:///c:/Users/Admin/Documents/Downloads/S5/DevSecOps/week%201/python/arithmetic_operations.py) |
| **2. String** | [`StringManipulatorTest.java`](file:///c:/Users/Admin/Documents/Downloads/S5/DevSecOps/week%201/java/StringManipulatorTest.java) | [`StringManipulator.java`](file:///c:/Users/Admin/Documents/Downloads/S5/DevSecOps/week%201/java/StringManipulator.java) | [`test_string_manipulator.py`](file:///c:/Users/Admin/Documents/Downloads/S5/DevSecOps/week%201/python/test_string_manipulator.py) | [`string_manipulator.py`](file:///c:/Users/Admin/Documents/Downloads/S5/DevSecOps/week%201/python/string_manipulator.py) |
| **3. Array/List** | [`ArrayOperationsTest.java`](file:///c:/Users/Admin/Documents/Downloads/S5/DevSecOps/week%201/java/ArrayOperationsTest.java) | [`ArrayOperations.java`](file:///c:/Users/Admin/Documents/Downloads/S5/DevSecOps/week%201/java/ArrayOperations.java) | [`test_array_operations.py`](file:///c:/Users/Admin/Documents/Downloads/S5/DevSecOps/week%201/python/test_array_operations.py) | [`array_operations.py`](file:///c:/Users/Admin/Documents/Downloads/S5/DevSecOps/week%201/python/array_operations.py) |
| **4. Email** | [`EmailValidatorTest.java`](file:///c:/Users/Admin/Documents/Downloads/S5/DevSecOps/week%201/java/EmailValidatorTest.java) | [`EmailValidator.java`](file:///c:/Users/Admin/Documents/Downloads/S5/DevSecOps/week%201/java/EmailValidator.java) | [`test_email_validator.py`](file:///c:/Users/Admin/Documents/Downloads/S5/DevSecOps/week%201/python/test_email_validator.py) | [`email_validator.py`](file:///c:/Users/Admin/Documents/Downloads/S5/DevSecOps/week%201/python/email_validator.py) |
| **5. Exception** | [`DividerTest.java`](file:///c:/Users/Admin/Documents/Downloads/S5/DevSecOps/week%201/java/DividerTest.java) | [`Divider.java`](file:///c:/Users/Admin/Documents/Downloads/S5/DevSecOps/week%201/java/Divider.java) | [`test_divider.py`](file:///c:/Users/Admin/Documents/Downloads/S5/DevSecOps/week%201/python/test_divider.py) | [`divider.py`](file:///c:/Users/Admin/Documents/Downloads/S5/DevSecOps/week%201/python/divider.py) |
| **6. CSV** | [`CsvConverterTest.java`](file:///c:/Users/Admin/Documents/Downloads/S5/DevSecOps/week%201/java/CsvConverterTest.java) | [`CsvConverter.java`](file:///c:/Users/Admin/Documents/Downloads/S5/DevSecOps/week%201/java/CsvConverter.java) | [`test_csv_converter.py`](file:///c:/Users/Admin/Documents/Downloads/S5/DevSecOps/week%201/python/test_csv_converter.py) | [`csv_converter.py`](file:///c:/Users/Admin/Documents/Downloads/S5/DevSecOps/week%201/python/csv_converter.py) |

## Test Coverage Per Exercise

| Exercise | Normal | Zero/Empty | Negative | Edge/Invalid | Total |
|----------|--------|------------|----------|-------------|-------|
| 1. Arithmetic | 4 | 3 | 3 | 1 | **11** |
| 2. String | 3 | 2 | — | 5 | **10** |
| 3. Array/List | 2 | 1 | 1 | 5 | **9** |
| 4. Email | 5 | — | — | 8 | **13** |
| 5. Divider | 3 | 1 | 3 | 2 | **9** |
| 6. CSV | 2 | 1 | — | 5 | **8** |
| | | | | **Grand Total** | **62** (Python) |

## How to Run

```bash
# Python — all tests
cd python
python -m pytest -v

# Java — requires JUnit 5.8.1 on classpath
cd java
javac -cp junit-jupiter-api-5.8.1.jar *.java
# Then run via IDE or Maven/Gradle test runner
```

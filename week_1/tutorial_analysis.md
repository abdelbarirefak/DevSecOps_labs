# 📋 Week 1 Unit Test Tutorial — Analysis

## Structure Overview

The tutorial is divided into **two parts**:

---

### Part I: Step-by-Step Tutorial (Walkthrough)

A guided introduction to writing unit tests in both languages:

| Step | Java (JUnit 5.8.1) | Python (Pytest) |
|------|-------------------|-----------------|
| **1** | Set up JDK, IDE, Maven dependency | Install Python 3.x, `pip install pytest` |
| **2** | Create `Calculator` class (`add`, `subtract`) | Create `calculator.py` (`add`, `subtract`) |
| **3** | Write `CalculatorTest` with `@Test` + `assertEquals` | Write `test_calculator.py` with `assert` + `@pytest.mark.parametrize` |
| **4** | Run via IDE (IntelliJ / Eclipse) | Run via `pytest` CLI |
| **5** | Analyze results, cover edge cases | Analyze results, cover edge cases |

---

### Part II: Exercises (6 total)

| # | Title | Core Task | Key Edge Cases |
|---|-------|-----------|----------------|
| **1** | Basic Arithmetic Operations | Multiplication & division class/module | Divide by zero, large numbers, negatives |
| **2** | String Manipulation | Reverse a string function | Empty strings, special characters, whitespace |
| **3** | Array/List Operations | Find maximum in an array | Single element, empty array, negatives, mixed |
| **4** | User Input Validation | Validate email addresses | Invalid formats, empty strings, `"@"` |
| **5** | Exception Handling | Division with exception on zero divisor | Normal division, zero divisor exception, negatives |
| **6** | Data Transformation | List of dicts → CSV string | Empty list, missing keys, non-dict items |

---

## Tutorial Requirements for Each Exercise

Every exercise explicitly requires:

1. ✅ **Implementation code** (class/methods in Java, module/functions in Python)
2. ✅ **Unit tests** covering normal, edge, and invalid cases
3. ✅ **Inline comments** explaining logic and algorithms

---

## Ready to Begin

> [!TIP]
> Tell me which **exercise number** (1–6) and which **language** (Java, Python, or both) you'd like to start with, and I'll generate the TDD solution.

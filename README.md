# Finish the Permissions (Classroom) App — Developer Guidance

This README is intentionally designed **not to give you the finished code**, but to **guide you as a developer** to complete the unfinished project using your own reasoning and by exploring the reference project that has already been provided to you.

Use this as a roadmap. Your task is to analyze, compare, and implement — **not copy**.

---

## 🎯 Project Goal

Complete the runtime permission handling inside:

`app/src/main/java/com/example/permissions_unfinished_for_classwork/MainActivity.kt`

The unfinished project includes placeholders and `TODO` markers. Your responsibility is to:

* Understand how Android runtime permissions work.
* Compare behaviors between Android versions (especially Android 13+ vs older).
* Identify gaps in the unfinished project.
* Use the **reference completed project** only for learning and inspiration.
* Implement missing logic in a clean, maintainable manner.

This exercise is about **thinking like an Android engineer**.

---

## 📂 What You Have

### ✔ Unfinished Project

Contains:

* UI elements
* Basic structure
* Empty methods / TODOs
* Permission buttons
* Status TextViews

### ✔ Completed Reference Project

Use it as a **learning resource** only. It shows the *expected behavior*, not the code you must copy.

Your job is to reverse‑engineer the required logic and write your own implementation.

---

## 🧭 What You Need to Implement (Conceptually)

These are the areas you must complete — but *how* you implement them is up to you.

### 1. Permission Request Flow

Understand how `ActivityResultContracts.RequestMultiplePermissions()` works and implement the callback logic so your app:

* Detects which permissions were granted or denied
* Reacts accordingly
* Updates the UI

### 2. Status Updating Logic

The project contains TextViews to show permission status.
You must:

* Check permission status at runtime
* Display results correctly
* Consider different behaviors for different Android API levels

### 3. Storage Permissions (Important)

Since Android 13 introduced new media permissions, you must:

* Detect the device's API level
* Request appropriate storage permissions
* Adjust UI logic accordingly

### 4. Single Permission Requests

Create clean, reusable logic for requesting individual permissions.

### 5. Notification Policy Access

Identify how to:

* Check whether access is granted
* Navigate the user to the correct settings page

---

## 🧠 How to Approach the Task

Here is a structured way to complete the project **without being given the solution**:

### 🔍 Step 1 — Study the reference project

Do NOT copy code.
Observe:

* The flow of methods
* UI updates
* How permissions are grouped
* What happens in different scenarios

### 🔍 Step 2 — Compare with the unfinished project

Identify:

* Missing functions
* Empty callbacks
* Incomplete logic paths

### 🔍 Step 3 — Recreate the logic your own way

Think in terms of:

* Clean Kotlin structure
* Separation of concerns
* Expandability for future permissions

### 🔍 Step 4 — Research Android documentation

Use official docs to understand:

* Runtime permission request lifecycle
* Storage permission changes in different API levels
* Best practices

### 🔍 Step 5 — Test on multiple Android versions

Especially:

* Android 12 or lower (legacy storage)
* Android 13+ (media permissions)

---

## 🛠 Skills You Will Practice

* Reading and understanding existing codebases
* Filling logical gaps
* Debugging permissions
* Understanding platform changes
* Writing clean and scalable Kotlin
* Thinking from a product and UX perspective

This project is designed to simulate real-world development behavior where you often inherit incomplete or legacy code and must bring it to a production-ready state.

---

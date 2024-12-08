# Management Hotel Booking System

## Overview

The **Management Hotel Booking System** is a Java-based console application that allows users to book hotel rooms conveniently. It provides a smooth experience for selecting room types, validating user inputs, calculating total costs, and generating booking details, ensuring a user-friendly approach to managing hotel reservations.

This system is a demonstration of **object-oriented programming (OOP)** principles, including inheritance, polymorphism, abstraction, and encapsulation.

---

## Features

### Room Options
The system offers three types of rooms:
1. **Standard Room**
   - Basic amenities like WiFi, TV, and air-conditioning.
   - Price: **$50 per night.**
2. **Deluxe Room**
   - Enhanced amenities such as rain shower, minibar, and king-sized bed.
   - Price: **$100 per night.**
3. **Presidential Suite**
   - The most luxurious experience with additional facilities like an entertainment room.
   - Price: **$150 per night.**

### Core Functionalities
- **User Input Validation**
  - Ensures correct formats for phone numbers, dates, and payment.
- **Dynamic Pricing**
  - Calculates total costs based on the room type and number of days.
- **Change Calculation**
  - Ensures the user has sufficient payment and provides change if necessary.
- **Randomized Farewell Message**
  - Enhances user engagement with a random friendly message at the end of the booking process.
- **Booking Details**
  - Displays a detailed summary of the user’s reservation, including check-in and check-out dates.

---

## How to Use

### 1. Run the Application
Execute the program using a Java compiler or IDE. The console will display a welcome message.

### 2. Room Details
The system will show details for all available room types. Press **Enter** to proceed after reviewing.

### 3. Booking Process
Follow the prompts to:
1. Enter your name and valid phone number.
2. Select your check-in date (format: YYYY-MM-DD).
3. Specify the number of days (between 2 and 12).
4. Choose a room type (1: Standard, 2: Deluxe, 3: Presidential).
5. Enter your payment amount.

### 4. Payment Validation
If your payment is insufficient, the system will prompt you to enter a new payment amount.

### 5. Booking Confirmation
The system calculates the total cost, generates a booking summary, and provides a farewell message.

---

## Code Structure

### Class Descriptions

1. **`Room` (Abstract Class)**
   - Represents the generic concept of a hotel room.
   - Fields: `name`, `description`, `price`.
   - Methods:
     - `displayRoom()`: Displays room details.
     - `getDetails()`: Abstract method to fetch room-specific features.

2. **Room Subclasses**
   - **`StandardRoom`**
   - **`DeluxeRoom`**
   - **`PresidentialSuite`**
   Each subclass implements `getDetails()` to provide specific room amenities.

3. **`Hotel`**
   - Manages the booking process, including input validation, cost calculations, and generating client details.
   - Handles:
     - User input (name, phone number, dates, room selection).
     - Payment validation and change calculation.
     - Displaying booking information.

4. **`ManagementHotelBookingSystem`**
   - Main class to run the application.
   - Handles the initialization of room types and orchestrates the booking process.

---

## OOP Principles in the Code

1. **Polymorphism**
   - The method `getDetails()` is overridden in the subclasses (`StandardRoom`, `DeluxeRoom`, `PresidentialSuite`) to provide room-specific details. When you call `getDetails()` on a `Room` object, Java will execute the correct version of the method depending on the actual object type (e.g., `StandardRoom`, `DeluxeRoom`).

2. **Inheritance**
   - `StandardRoom`, `DeluxeRoom`, and `PresidentialSuite` extend the `Room` class. These subclasses inherit the properties and methods of the `Room` class and override the `getDetails()` method to provide specific room features.

3. **Encapsulation**
   - The `Hotel` class encapsulates customer details and booking information, ensuring that data is hidden and accessed through getter and setter methods. The class provides a controlled interface for interacting with the user's booking data.

4. **Abstraction**
   - The `Room` class is abstract, and its abstract method `getDetails()` is implemented by the subclasses. This allows for a generic `Room` type while allowing different room types to provide their own specific implementations of `getDetails()`.

---

## Example Output

```text
Welcome to our Management Hotel Booking System! Press Enter to view more details.

========================================Standard Room========================================
Our Standard Room offers comfort and convenience.
Room Details:
- Smart Television with Satellite Channels
- High-Speed WiFi
- Bathrooms
- Closet
- In-room Refrigerator
- Individually Air-conditioning System
- Coffee/Tea Maker
Price Rate: $50 per night

...

Book Processing...

Enter your name: John Doe
Enter your phone number: 1234567890
Enter date in format YYYY-MM-DD: 2023-12-10
How many days will you be staying (Min: 2, Max: 12): 3
Enter the choice of room (1: Standard, 2: Deluxe, 3: Presidential): 2
Enter your payment: 400
Total: $300
Your change is: $100

========================================CLIENT'S INFORMATION========================================
Name: John Doe
Mobile no.: 1234567890
Date of check-in: 12/10/2023
Date of check-out: 12/13/2023
Days staying: 3
Nights staying: 2
Chosen room: Deluxe Room

Welcome! Your comfort is our priority. Have a great stay! See you!

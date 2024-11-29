# Railway Ticket Management System

This Java application provides a seamless e-ticket management experience for metro rail and railway users in Bangladesh. It allows users to manage their accounts, purchase tickets, and view travel history, all within one platform.

---
## Table of Contents
- [Authors](#authors)
- [Responsibilities](#Responsibilities)
- [Prerequisites](#prerequisites)
- [Get Started](#get-started)
  - [Clone the Repository](#clone-the-repository)
  - [Environment Setup](#environment-setup)
- [Architecture/Technology Sections](#architecturetechnology-sections)
- [Features](#features)
- [Technology Used](#technology-used)
- [Feedback](#feedback)
- [License](#license)
- [Acknowledgements](#acknowledgements)
- [Contact](#contact)

---
## Authors

- [Md. Sazzad Khan](https://www.linkedin.com/in/md-sazzad-khan-78083a257/)
- [S. S. Zobaer Ahmed](https://www.github.com/sszobaer)
- [Raiyan Rafiq Sarker](https://github.com/RaiyanRafiqSarker)
- [Mahdi Rahman Mahit]()
---
## Responsibilities

### Project Team Members and Their Roles

| Name                   | Role                                  | Responsibilities                                                                                                                                   |
|------------------------|---------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------|
| **Md. Sazzad Khan** | Project Lead, Backend Developer      | - Led the project and coordinated tasks among team members. <br> - Developed the core backend functionality for user authentication, ticket booking, and transaction management. <br> - Ensured integration and functionality of database components. |
| **S. S. Zobaer Ahmed**    | UI/UX Designer, Full Stack Developer   | - Designed user interfaces for a seamless user experience. <br> - Developed the frontend & Backend components for user registration, login, and ticket purchase. <br> - Collaborated with backend developers to ensure smooth data flow between frontend and backend. |
| **Raiyan Rafiq Sarker**| Database Administrator, Tester       | - Designed and managed the database schema for user, ticket, and transaction data. <br> - Ensured data integrity and security. <br> - Conducted functionality testing and validation for all major components. |
| **Mahdi Rahman Mahit** | Documentation Specialist, Support    | - Created detailed documentation and user guides for the application. <br> - Assisted in developing and organizing project resources. <br> - Provided additional support for testing and bug resolution. |

Each team member contributed uniquely to the project, ensuring a successful and comprehensive e-ticket management system. The collaboration and distinct responsibilities enhanced the project's quality and efficiency, meeting the requirements and providing an effective solution for metro rail and railway e-ticketing in Bangladesh.


## Prerequisites

Before starting, ensure you have the following installed:
- **Notepad++:** [Download the latest version](https://notepad-plus-plus.org/downloads/)
- **JDK development Kit:** Available on Oracle [Oracle's official site](https://www.oracle.com/java/technologies/downloads/)
- **Eclips:** You can also use the Eclips instead of Notepad++ [Download the latest version](https://www.eclipse.org/downloads/)

## Get Started

### Clone the Repository

Obtain your own copy of the project with:
    
```bash
git clone https://github.com/sszobaer/Railway-Ticket-Management-System.git
cd Railway-Ticket-Management-System
```

### Environment Setup
To set up your Java environment:

1. **Download and Install JDK**: Ensure that the Java Development Kit (JDK) is installed on your system. [Download the latest JDK version](https://www.oracle.com/java/technologies/javase-downloads.html) if you haven’t already.

2. **Set Up Environment Variables**:
   - Add the JDK `bin` directory to your system's PATH variable:
     - **Windows**: 
       1. Open **System Properties** > **Environment Variables**.
       2. Under **System Variables**, find and edit the `Path` variable to include the path to the JDK `bin` folder (e.g., `C:\Program Files\Java\jdk-x.x.x\bin`).
     - **macOS/Linux**: Open your terminal and edit the `.bash_profile`, `.bashrc`, or `.zshrc` file, adding `export PATH=$PATH:/path/to/jdk/bin`.

3. **Verify the Installation**:
   - Open a terminal or command prompt.
   - Run the command: `java -version`. If Java is properly installed, it will display the installed Java version.

4. **Install an IDE (Optional)**: 
   - You can use any IDE, but **IntelliJ IDEA** or **Eclipse** are recommended for Java development.
   - [IntelliJ IDEA Download](https://www.jetbrains.com/idea/download/)
   - [Eclipse Download](https://www.eclipse.org/downloads/)

### Architecture/Technology Sections
  
<h4>Home Page</h4>  

![Screenshot 2024-11-04 182937](https://github.com/user-attachments/assets/d22a39dc-787c-444c-9244-48b04964d48d)

<h4>Sign Up page</h4>

![Screenshot 2024-11-04 182823](https://github.com/user-attachments/assets/71ace0dc-fa5b-4feb-a515-24a8d4164be8)

<h4>Customer Dahsboard</h4>

![Screenshot 2024-11-04 183003](https://github.com/user-attachments/assets/573321a8-1937-4e8c-9786-c26c0865b873)

<h4>Inter City Ticket Booking</h4>

![Screenshot 2024-11-04 183003](https://github.com/user-attachments/assets/55d9fd16-b3c3-4195-bf6d-2dc369e77b7c)

<h4>Inter City Ticket Booking Confirmation</h4>

![Screenshot 2024-11-04 183117](https://github.com/user-attachments/assets/074e3a56-0daa-4a5e-b836-cce04de97d02)

<h4>Metro Rail Ticket Booking </h4>

![Screenshot 2024-11-04 183208](https://github.com/user-attachments/assets/799bf4ef-7a50-41db-8a7e-e370c95be71a)

<h4>Metro Rail Ticket Booking Confirmation</h4>

![Screenshot 2024-11-04 183218](https://github.com/user-attachments/assets/f9e220c4-d0c1-4724-a93a-aedfc2c7f21f)

<h4>Check History and Log out </h4>

![Screenshot 2024-11-04 183129](https://github.com/user-attachments/assets/ea9ea827-1ff0-4733-9b96-f528d370cfff)


## Features
- **User Registration & Login**: New users can sign up, while returning users can log in to access their accounts.
- **Ticket Purchase**: Users can buy tickets for metro rail or railway journeys, selecting from available destinations.
- **Destination Information**: View a list of available destinations for both metro and railway systems.
- **Account Recharge**: Users can recharge their balance within the application to streamline the ticket purchase process.
- **Booking History**: Review previously purchased tickets and transaction history for easy reference.
- **Booked Tickets**: View details of currently booked tickets.

## Technology Used
- **[JAVA](https://dev.java/learn/getting-started/):** Java is a high-level, object-oriented programming language known for its platform independence, enabling developers to write code once and run it anywhere with a compatible JVM (Java Virtual Machine).
- **[Notepad++](https://notepad-plus-plus.org/downloads/):** Notepad++ can be used to write Java code by configuring it to recognize `.java` files, allowing syntax highlighting and saving code files for compilation and execution through the command line.

## Feedback

If you have any feedback or suggestions for this project, please feel free to reach out or submit an issue on the [GitHub repository(https://github.com/sszobaer/Railway-Ticket-Management-System/issues).

## License

This project is licensed under the MIT License - see the [LICENSE](https://github.com/sszobaer/Railway-Ticket-Management-System/blob/main/LICENSE) file for details.

## Acknowledgements

Special thanks to:
- **Oracle** for their development tools and platform.
- **Stack Overflow** and **GitHub** communities for their valuable support and resources.
- And Also <br>
🎓 **Rifath Mahmud**  <br>
🎓 Assistant Professor, Department of Computer Science, AIUB <br>
Your guidance has been instrumental in the development of this project.


## Contact

For more information, reach out to:

- **Email:** [ahmedsszobaer@gmail.com](mailto:ahmedsszobaer@gmail.com)
- **GitHub:** [S. S. Zobaer Ahmed](https://www.github.com/sszobaer)
- **Linkedin:** [S. S. Zobaer Ahmed](https://www.linkedin.com/in/s-s-zobaer-ahmed-209bab296?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app)
- **YouTube Channel:** [Code Craft Zobaer](https://www.youtube.com/@CodeCraftZobaer)

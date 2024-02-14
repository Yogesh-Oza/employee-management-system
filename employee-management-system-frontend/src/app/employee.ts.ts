

export class Employee {
    id: number;
  
    constructor() {
      this.id = 0;
      this.firstName = "";
      this.lastName = "";
      this.emailId = "";
      this.active=false;
      this.employees = []; // Assigning a value in the constructor
  }
    
  
    firstName: string;
    lastName: string;
    emailId: string;
    active: boolean;
  
  
    employees: Employee[]; // Property declaration
  
  }
  
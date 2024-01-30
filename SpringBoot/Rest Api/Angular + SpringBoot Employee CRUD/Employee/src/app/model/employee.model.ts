export class Employee{
    id?: number;
    name?: string;
    email?: string;
    gender?: string;
    
    department?: {
        did?: number;
        dname?: string;
        demail?: string;
        daddress?: string;
    }
}
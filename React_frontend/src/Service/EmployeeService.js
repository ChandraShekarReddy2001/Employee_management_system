import axios from 'axios';
import { useNavigate } from 'react-router-dom';
const EMPLOYEE_BASE_URL = "http://localhost:9090/api/e1/employees";
const EMPLOYEE_LOGIN_URL = "http://localhost:9090/api/employee/login";
class EmployeeService {
    getEmployee() {
        return axios.get(EMPLOYEE_BASE_URL);
    }
    createEmployee(employee) {
        return axios.post(EMPLOYEE_BASE_URL,employee)
    }
    getEmployeeById(employeeId) {
        return axios.get(EMPLOYEE_BASE_URL + '/' + employeeId);
    }
    updateEmployee(employeeId, employee) {
        return axios.put(EMPLOYEE_BASE_URL + '/' + employeeId, employee);
    }
    deleteEmployee(employeeId) {
        return axios.delete(EMPLOYEE_BASE_URL + '/' + employeeId);
    }
    getLogin(login) {
        try {
       
            return axios.post(EMPLOYEE_LOGIN_URL, login);
        
        }
        catch (e) {
            console.log(e);
        }
    }
    


}
export default new EmployeeService();
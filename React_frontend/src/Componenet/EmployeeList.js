import React, { Component } from 'react'
import EmployeeService from '../Service/EmployeeService';
import { Link } from 'react-router-dom';
export default class EmployeeList extends Component {

   
    constructor(props) {
        super(props);
        this.state = {
            employees: []};
    }
    
    componentDidMount() {
        EmployeeService.getEmployee().then((res) => {
            this.setState({ employees: res.data })
        })
    }
   
    
    
    deleteEmployee = (employeeId) => {
        EmployeeService.deleteEmployee(employeeId).then(res => {
            EmployeeService.getEmployee().then((res) => {
                this.setState({ employees: res.data })
            })

        }).catch(error => {
            console.log(error);
        })
    }
   
  render() {
    return (
      <div className='container'>
            <h2 className='text-center mt-4 mb-4'>Employee List</h2>
            <div className='row'>
                <Link to="/addemployee" className='btn btn-outline-primary mt-4 w-100'>Add Employee</Link>      
            <table className='table w-100 table-striped table-bordered'>
               <thead>
                    <tr>
                    <th>Id</th>
                    <th>First Name</th>
                    <th>LastName</th>
                    <th>Email</th>
                    <th>Address</th>
                            <th>PhoneNumber</th>
                            <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        this.state.employees.map(
                            (employee,index) =>
                                <tr key={employee.id}>
                                    <td>{index+1}</td>
                                    <td>{employee.firstName}</td>
                                    <td>{employee.lastName}</td>
                                    <td>{employee.email}</td>
                                    <td>{employee.address}</td>
                                    <td>{employee.phoneNumber}</td>
                                    <td><Link to={`/updateEmployee/${employee.id}`} className='btn btn-info '>Update </Link>
                                        <button onClick={() => this.deleteEmployee(employee.id)} className='btn btn-danger float-end'>Delete </button>
                                    </td>
                                </tr>
                                
                        )
                    }
                </tbody>
            </table>
            </div>
            </div>
    )
  }
}


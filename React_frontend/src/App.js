import React from 'react'
import EmployeeList from './Componenet/EmployeeList';
import HeaderComponenet from './Componenet/HeaderComponent';
import FooterComponent from './Componenet/FooterComponent';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import CreateEmployeeComponent from './Componenet/CreateEmployeeComponent';
import UpdateEmployeeComponent from './Componenet/UpdateEmployeeComponent';
import LoginComponent from './Componenet/LoginComponent';
import PrivateRouteComponent from './Componenet/PrivateRouteComponent';
import './App.css';
export default function App() {
  const isAuthenticated = localStorage.getItem('flag');
  return (
    <div >
      <HeaderComponenet />
      <Router>
      <div className='countainer'>
        <Routes>
            <Route exact path='/' element={isAuthenticated ? <EmployeeList />:<LoginComponent/>}></Route>
            <Route path='/employees' element={<EmployeeList />}></Route>
            <Route path='/addemployee' element={<CreateEmployeeComponent />}></Route>
            <Route path='/updateEmployee/:id' element={<UpdateEmployeeComponent />}></Route>
            <Route path='/login' element={<LoginComponent/>}></Route>
        </Routes>
        </div>
      </Router>
      <FooterComponent/>
    </div>
  )
}

import React, { use, useState } from 'react'
import { useNavigate } from 'react-router-dom';
import EmployeeService from '../Service/EmployeeService';
export default function LoginComponent() {
    let navigate = useNavigate();

    const [login, setlogin] = useState(
        {
            username:"",
            password:""
        }
    );
    const handleClick = (e) => {
        const name = e.target.name;
        const value = e.target.value;
        setlogin({ ...login, [name]: value });
    }
     const saveHandler = async(e) => {
         e.preventDefault();
         console.log(login);
         const cradentials =await EmployeeService.getLogin(login);
         const { token } = cradentials.data;
         localStorage.setItem('flag', token);
         if(cradentials.data == true) {
             navigate('/employees');
         }
         else {
             
             navigate('/login');
         }
      }
  return (
      <div>
          <section>
              <div className="container py-5 ">
                  <div className="row d-flex justify-content-center align-items-center">
                      <div className="col-12 col-md-8 col-lg-6 col-xl-5">
                          <div className="card shadow-2-strong" style={{background:'skyblue'}} >
                              <div className="card-body p-5 text-center">

                                  <h3 className="mb-5">Sign in</h3>

                                  <div data-mdb-input-init className="form-outline mb-4">
                                      <input type="email" name='username' className="form-control form-control-lg" placeholder='UserName'
                                          value={login.username} onChange={handleClick}
                                      />
                                     
                                  </div>

                                  <div data-mdb-input-init className="form-outline mb-4">
                                      <input type="password" name='password' className="form-control form-control-lg" placeholder='Password'
                                          value={login.password} onChange={handleClick}
                                      />
                                     
                                  </div>

    

                                  <button data-mdb-button-init data-mdb-ripple-init className="btn btn-primary btn-lg btn-block" type="submit" onClick={saveHandler}>Login</button>
                                  <button data-mdb-button-init data-mdb-ripple-init className="btn btn-success btn-lg btn-block float-end" type="submit">Sign Up</button>

                                  
                              </div>
                          </div>
                      </div>
                  </div>
              </div>
          </section>
    </div>
  )
}

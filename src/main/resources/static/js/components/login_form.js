import React, {Component} from 'react';

export default class LoginForm extends Component {
    render() {
        return (
            <div>
                <img src="/images/login.jpg" className="img-responsive center-block" width="300" height="300" alt="Logo"/>
                <form action="/login" method="POST" className="form-signin">
                    <h3 className="form-signin-heading">Welcome</h3>
                    <br/>

                    <input type="text" id="email" name="email" placeholder="Email" className="form-control"/> <br/>
                    <input type="password" placeholder="Password" id="password" name="password" className="form-control"/> <br />

                    <button className="btn btn-lg btn-primary btn-block" name="Submit" value="Login" type="Submit" >Login</button>
                </form>
            </div>
        );
    }
}
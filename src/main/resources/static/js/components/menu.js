import React, { Component } from 'react';

class Menu extends Component {
    render() {
        return (
            <div>
                <form action="/registration" method="get">
                    <button className="btn btn-md btn-warning btn-block" type="Submit">Go To Registration Page</button>
                </form>
            </div>
        );
    }
}


export default Menu;
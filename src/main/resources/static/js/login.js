import React from 'react';
import ReactDOM from 'react-dom';

import LoginForm from './components/login_form';
import Menu from './components/menu';


ReactDOM.render(<Menu />, document.querySelector('.menu'));
ReactDOM.render(<LoginForm />, document.querySelector('.container'));
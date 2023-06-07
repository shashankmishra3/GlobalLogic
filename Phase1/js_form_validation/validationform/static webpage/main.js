// get form elements.
const usernameEl    = document.querySelector('#username');
const emailEl       = document.querySelector('#email');
const passwordEl    = document.querySelector('#password');
const confirmPassEl = document.querySelector('#confirm-pass');
const formEl        = document.querySelector('#signup');

// utility function for validation
const isRequired    = value => value === '' ? false : true; 
const inBetween     = (length, min, max) => length < min || length > max ? false : true;
const isEmailValid  = (email) => {
    const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
}
const isPassSecure  = (password) => {
    const re = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})");
    return re.test(password);
}

// highlight the border and display error message
const showError = (input, message) => {
    const formField = input.parentElement;

    formField.classList.remove('success');
    formField.classList.add('error');

    const error = formField.querySelector('small');
    error.textContent = message;
};

// highlight the success border and remove error message
const showSuccess = (input) => {
    const formField = input.parentElement;

    formField.classList.remove('error');
    formField.classList.add('success');

    const error = formField.querySelector('small');
    error.textContent = '';
}

// function validate username input 
const checkUserName = () => {
    let valid   = false;
    const min   = 5,
          max   = 30;

    const username = usernameEl.value.trim();

    if(!isRequired(username)) {
        showError(usernameEl, "Username cannot be blank.");
    } else if (!inBetween(username.length, min, max)) {
        showError(usernameEl, `Username must be between ${min} and ${max} character.`);
    } else {
        showSuccess(usernameEl);
        valid = true;
    }
    return valid;
}

// function validate email input
const checkEmail = () => {
    let valid   = false;
    const email = emailEl.value.trim();
    if (!isRequired(email)) {
        showError(emailEl, "Email cannot be blank.");
    } else if (!isEmailValid(email)){
        showError(emailEl, "Email is not valid.");
    } else {
        showSuccess(emailEl);
        valid = true;
    }
    return valid;
}

// function validate password input 
const checkPassword = () => {   
    let valid = false;
    const password = passwordEl.value.trim();
    if (!isRequired(password)) {
        showError(passwordEl, "Password cannnot be blank.");
    } else if (!isPassSecure(password)) {
        showError(passwordEl, "Password must be at least 8 characters that include at least 1 lowercase character, 1 uppercase characters, 1 number, and 1 special character in (!@#$%^&*)");
    } else {
        showSuccess(passwordEl);
        valid = true;
    }
    return valid;
}

// function validate confirm password input
const checkConfirmPassword = () => {
    let valid           = false;
    const password      = passwordEl.value.trim();
    const confirmpass   = confirmPassEl.value.trim();

    if (!isRequired(confirmpass)) {
        showError(confirmPassEl, "Please enter the password again.");
    } else if (password !== confirmpass) {
        showError(confirmPassEl, "Confirm password does not match.");
    } else {
        showSuccess(confirmPassEl);
        valid = true;
    }
    return valid;
}

// validate inputs after user stop typing
const debounce = (fn, delay = 500) => {
    let timeoutId;
    return (...args) => {
        if(timeoutId) {
            clearTimeout(timeoutId);
        }
        timeoutId = setTimeout(() => {
            fn.apply(null, args)
        }, delay);
    };
};

formEl.addEventListener('input', debounce( function (e) {
    switch(e.target.id) {
        case 'username':
            checkUserName();
            break; 
        case 'email':
            checkEmail();
            break;
        case 'password':
            checkPassword();
            break;
        case 'confirm-pass':
            checkConfirmPassword();
            break;
    }
}));

// form submit function event
formEl.addEventListener('submit', function(e) {
    // prevent default submission action of form.
    e.preventDefault();

    // validate form
    let isUserNameValid      = checkUserName(),
        isEmailValid         = checkEmail(),
        isPasswordValid      = checkPassword(),
        isCnfrmPasswordValid = checkConfirmPassword();   

    let isFormValid = isUserNameValid && isEmailValid && isPasswordValid && isCnfrmPasswordValid;

    if(isFormValid) {
        let textContent = '';
        const formData = new FormData(formEl);
        console.log(formData);
        for (const [key, value] of formData) {
            textContent += `${key}: ${value}\n`;
        }
        console.log(textContent);
    }
});



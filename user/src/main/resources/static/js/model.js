function User(userEmail, userPassword) {
    this.userEmail = userEmail;
    this.userPassword = userPassword;
}

function ResultData(responseCode, data, description) {
    this.responseCode = responseCode;
    this.data = data;
    this.description = description;
}

let ResponseCode = {
    RESPONSE_OK : "RESPONSE_OK",
    RESPONSE_ERROR : "RESPONSE_ERROR",
    RESPONSE_NULL : "RESPONSE_NULL"
};
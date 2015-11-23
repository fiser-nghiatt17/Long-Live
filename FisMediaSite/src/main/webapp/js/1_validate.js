var errorMessages = {
    rules:{
        username: {
            required: true,
            minlength: 6,
            maxlength: 20
        },
        password: {
            required: true,
            minlength: 6,
            maxlength: 20
        },
        confirmPassword: {
            required: true,
            minlength: 6,
            maxlength: 20,
            equalTo: "#signUpPassword"
        },
        fullName: {
            required: true,
            minlength: 6,
            maxlength: 20
        },
        userImage:{
            required: true,
            accept: "image/*",
            fileSize: 1048576
        },
        albumName:{
            required: true
        }
    },
    messages:{/*ss*/
        username: {
            required: "This field is required",
            minlength: "Username must be 6-20 characters",
            maxlength: "Username must be 6-20 characters"
        },
        password: {
            required: "This field is required",
            minlength: "Password must be 6-20 characters",
            maxlength: "Password must be 6-20 characters"
        },
        confirmPassword: {
            required: "This field is required",
            minlength: "Password must be 6-20 characters",
            maxlength: "Password must be 6-20 characters",
            equalTo: "Not match"
        },
        fullName: {
            required: "This field is required",
            minlength: "Too short",
            maxlength: "Too long"
        },
        userImage:"File must be JPG, GIF or PNG, less than 1MB"
    }
};

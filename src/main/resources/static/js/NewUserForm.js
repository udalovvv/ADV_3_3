const newUserForm = document.getElementById("NewUserForm");
newUserForm.addEventListener("submit", (e) => {
    e.preventDefault();

    const formData = new FormData(newUserForm);
    const object = {
        roles: []
    };

    formData.forEach((value, key) => {
        if (key === "rolesId") {
            const roleId = value;
            const role = {
                role: roleId
            };
            object.roles.push(role);
        } else {
            object[key] = value;
        }
    });
    console.log(object)


    fetch("api/users", {
        method: "POST",
        headers: {
            "Content-type": "application/json"
        },
        body: JSON.stringify(object)
    })
        .then(() => getUsers())
        .then(() => newUserForm.reset());


    return show('Page1','Page2');
})
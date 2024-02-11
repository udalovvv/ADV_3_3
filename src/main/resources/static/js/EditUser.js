const formEdit = document.getElementById("formEdit");
formEdit.addEventListener('submit', e => {
    e.preventDefault();

    const formData = new FormData(formEdit);
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

    const id = formData.get("id");
    fetch(`api/users/${id}`, {
        method: "PUT",
        headers: {
            "Content-type": "application/json"
        },
        body: JSON.stringify(object)
    })
        .then(response => {
            if (response.ok) {
                return response.json();
            }

            throw new Error("Ошибка при обновлении пользователя.");
        })
        .then(updatedUser => {
            console.log(updatedUser);
            getUsers();
        })
        .catch(error => {
            console.error(error);
        });

    $("#ModalEdit").modal("hide");
    formEdit.reset();
});

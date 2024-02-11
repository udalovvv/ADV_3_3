
async function getUsers() {
    const response = await fetch("api/users");

    if (response.ok) {
        let json = await response.json();
        replaceTable(json);
        replaceTableUser(json);

    } else {
        alert("Ошибка HTTP: " + response.status);
    }

    function replaceTable(data) {
        const placement = document.getElementById("usersTablePlacement")
        placement.innerHTML = "";
        data.forEach(({id, firstName, lastName, age, email, authorities}) => {
            let userRoles = "";
            authorities.forEach((role) => {
                userRoles = userRoles + role.role + " ";
            })
            const element = document.createElement("tr");
            element.innerHTML = `
            <th scope="row">${id}</th>
            <td>${firstName}</td>
            <td>${lastName}</td>
            <td>${age}</td>
            <td>${email}</td>
            <td>${userRoles}</td>
            <td>
                <button type="button" class="btn btn-info text-white" data-bs-userId=${id}
                    data-bs-userFirstName=${firstName} data-bs-userLastName=${lastName} data-bs-userAge=${age}
                    data-bs-userEmail=${email} data-bs-toggle="modal"
                    data-bs-target="#ModalEdit">Edit</button>
            </td>

            <td>
                <button type="button" class="btn btn-danger" data-bs-userId=${id}
                    data-bs-userFirstName=${firstName} data-bs-userLastName=${lastName} data-bs-userAge=${age}
                    data-bs-userEmail=${email} data-bs-toggle="modal"
                    data-bs-target="#ModalDelete">Delete</button>
            </td>
            `
            placement.append(element);
        })
    }

    function replaceTableUser(data) {
        const params = new URLSearchParams(window.location.search);
        const userId = parseInt(params.get('id'));
        const user = data.find((user) => user.id === userId);
        const placement = document.getElementById("userTablePlacement")
        placement.innerHTML = "";
        const { id, firstName, lastName, age, email, authorities } = user;
        let userRoles = "";
        authorities.forEach((role) => {
            userRoles = userRoles + role.role + " ";
        });
        const element = document.createElement("tr");
        element.innerHTML = `
            <th scope="row">${id}</th>
            <td>${firstName}</td>
            <td>${lastName}</td>
            <td>${age}</td>
            <td>${email}</td>
            <td>${userRoles}</td>
            <td>
            `
        placement.append(element);
    }
}

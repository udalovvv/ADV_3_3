
async function getUser() {
    const params = new URLSearchParams(window.location.search);
    const id = params.get('id');

    const response = await fetch("api/user?id="+id);

    if (response.ok) {
        let json = await response.json()
            .then(data => replaceTable(data));
    } else {
        alert("Ошибка HTTP: " + response.status);
    }

    function replaceTable(data) {

        const placement = document.getElementById("userTablePlacement")
        placement.innerHTML = "";
        const { id, firstName, lastName, age, email, authorities } = data;
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

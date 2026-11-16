const API = '../users';

const tbody = document.getElementById('userRows');
const message = document.getElementById('message');

function showMessage(text, isError) {
    message.textContent = text;
    message.className = isError ? 'error' : '';
}

async function request(url, options) {
    const response = await fetch(url, options);
    if (!response.ok) {
        throw new Error('请求失败：' + response.status);
    }
    return response.json();
}

async function loadUsers() {
    try {
        const result = await request(API);
        if (!Array.isArray(result.data)) {
            showMessage(result.message || '获取数据失败', true);
            return;
        }
        tbody.innerHTML = '';
        result.data.forEach(function (user) {
            const tr = document.createElement('tr');
            tr.innerHTML =
                '<td>' + user.id + '</td>' +
                '<td>' + user.username + '</td>' +
                '<td>' + user.password + '</td>' +
                '<td>' +
                '<button type="button" onclick="editUser(' + user.id + ', \'' + user.username + '\', \'' + user.password + '\')">修改</button> ' +
                '<button type="button" class="danger" onclick="deleteUser(' + user.id + ')">删除</button>' +
                '</td>';
            tbody.appendChild(tr);
        });
        showMessage('共 ' + result.data.length + ' 条记录');
    } catch (e) {
        showMessage('无法加载数据：' + e.message, true);
    }
}

async function saveUser() {
    const username = document.getElementById('newUsername').value.trim();
    const password = document.getElementById('newPassword').value.trim();
    if (!username || !password) {
        showMessage('请输入用户名和密码', true);
        return;
    }
    try {
        const result = await request(API, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json;charset=UTF-8' },
            body: JSON.stringify({ username: username, password: password })
        });
        showMessage(result.message, result.data !== true);
        if (result.data === true) {
            document.getElementById('newUsername').value = '';
            document.getElementById('newPassword').value = '';
            loadUsers();
        }
    } catch (e) {
        showMessage('保存失败：' + e.message, true);
    }
}

function editUser(id, username, password) {
    document.getElementById('editId').value = id;
    document.getElementById('editUsername').value = username;
    document.getElementById('editPassword').value = password;
}

async function updateUser() {
    const id = document.getElementById('editId').value;
    if (!id) {
        showMessage('请先选择要修改的记录', true);
        return;
    }
    try {
        const result = await request(API, {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json;charset=UTF-8' },
            body: JSON.stringify({
                id: Number(id),
                username: document.getElementById('editUsername').value.trim(),
                password: document.getElementById('editPassword').value.trim()
            })
        });
        showMessage(result.message, result.data !== true);
        if (result.data === true) {
            document.getElementById('editId').value = '';
            document.getElementById('editUsername').value = '';
            document.getElementById('editPassword').value = '';
            loadUsers();
        }
    } catch (e) {
        showMessage('更新失败：' + e.message, true);
    }
}

async function deleteUser(id) {
    if (!confirm('确定删除 id 为 ' + id + ' 的记录吗？')) {
        return;
    }
    try {
        const result = await request(API + '/' + id, { method: 'DELETE' });
        showMessage(result.message, result.data !== true);
        if (result.data === true) {
            loadUsers();
        }
    } catch (e) {
        showMessage('删除失败：' + e.message, true);
    }
}

document.addEventListener('DOMContentLoaded', loadUsers);

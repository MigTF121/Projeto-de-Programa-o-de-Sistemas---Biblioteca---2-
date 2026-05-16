//area de livros
async function asyncCriarLivro(dadosLivro, proxsucesso, proxerro) {
    const URL = `/api/livros`;
    const postRequest = {
        method: 'POST',
        body: JSON.stringify(dadosLivro),
        headers: { 'Content-type': 'application/json' }
    };
    fetch(URL, postRequest)
        .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta; })
        .then(resposta => resposta.json())
        .then(jsonResponse => proxsucesso())
        .catch(proxerro);
}

async function asyncLerLivros(proxsucesso, proxerro) {
    const URL = `/api/livros`;
    fetch(URL)
        .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta; })
        .then(resposta => resposta.json())
        .then(jsonresponse => proxsucesso(jsonresponse))
        .catch(proxerro);
}

async function asyncLerLivroById(id, proxsucesso, proxerro) {
    const URL = `/api/livros/${id}`;
    fetch(URL)
        .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta; })
        .then(resposta => resposta.json())
        .then(jsonresponse => proxsucesso(jsonresponse))
        .catch(proxerro);
}

async function asyncAlterarLivro(dadosLivro, proxsucesso, proxerro) {
    const URL = `/api/livros/${dadosLivro.codigoLivro}`;
    const putRequest = {
        method: 'PUT',
        body: JSON.stringify(dadosLivro),
        headers: { 'Content-type': 'application/json' }
    };
    fetch(URL, putRequest)
        .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta; })
        .then(resposta => resposta.json())
        .then(jsonResponse => proxsucesso())
        .catch(proxerro);
}

async function asyncApagarLivro(id, proxsucesso, proxerro) {
    const URL = `/api/livros/${id}`;
    const deleteRequest = { method: 'DELETE' };
    fetch(URL, deleteRequest)
        .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta; })
        .then(resposta => proxsucesso())
        .catch(proxerro);
}


//area de emprestimos

async function asyncCriarEmprestimo(dadosEmprestimo, proxsucesso, proxerro) {
    const URL = `/api/emprestimos`;
    const postRequest = {
        method: 'POST',
        body: JSON.stringify(dadosEmprestimo),
        headers: { 'Content-type': 'application/json' }
    };
    fetch(URL, postRequest)
        .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta; })
        .then(resposta => resposta.json())
        .then(jsonResponse => proxsucesso())
        .catch(proxerro);
}

async function asyncLerEmprestimos(proxsucesso, proxerro) {
    const URL = `/api/emprestimos`;
    fetch(URL)
        .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta; })
        .then(resposta => resposta.json())
        .then(jsonresponse => proxsucesso(jsonresponse))
        .catch(proxerro);
}

async function asyncDevolverEmprestimo(id, proxsucesso, proxerro) {
    const URL = `/api/emprestimos/${id}/devolver`;
    const putRequest = { method: 'PUT' };
    fetch(URL, putRequest)
        .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta; })
        .then(resposta => proxsucesso())
        .catch(proxerro);
}

async function asyncLerUsuarios(proxsucesso, proxerro) {
    const URL = `/api/usuarios`;
    fetch(URL)
        .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta; })
        .then(resposta => resposta.json())
        .then(jsonresponse => proxsucesso(jsonresponse))
        .catch(proxerro);
}

async function asyncLerExemplaresDisponiveis(proxsucesso, proxerro) {
    const URL = `/api/exemplares/disponiveis`;
    fetch(URL)
        .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta; })
        .then(resposta => resposta.json())
        .then(jsonresponse => proxsucesso(jsonresponse))
        .catch(proxerro);
}

//area para funcionário

async function asyncCriarFuncionario(dadosFuncionario, proxsucesso, proxerro) {
    const URL = `/api/funcionarios`;
    const postRequest = {
        method: 'POST',
        body: JSON.stringify(dadosFuncionario),
        headers: { 'Content-type': 'application/json' }
    };
    fetch(URL, postRequest)
        .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta; })
        .then(resposta => resposta.json())
        .then(jsonResponse => proxsucesso())
        .catch(proxerro);
}

async function asyncLerFuncionarios(proxsucesso, proxerro) {
    const URL = `/api/funcionarios`;
    fetch(URL)
        .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta; })
        .then(resposta => resposta.json())
        .then(jsonresponse => proxsucesso(jsonresponse))
        .catch(proxerro);
}

async function asyncLerFuncionarioById(id, proxsucesso, proxerro) {
    const URL = `/api/funcionarios/${id}`;
    fetch(URL)
        .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta; })
        .then(resposta => resposta.json())
        .then(jsonresponse => proxsucesso(jsonresponse))
        .catch(proxerro);
}

async function asyncAlterarFuncionario(dadosFuncionario, proxsucesso, proxerro) {
    const URL = `/api/funcionarios/${dadosFuncionario.id}`;
    const putRequest = {
        method: 'PUT',
        body: JSON.stringify(dadosFuncionario),
        headers: { 'Content-type': 'application/json' }
    };
    fetch(URL, putRequest)
        .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta; })
        .then(resposta => resposta.json())
        .then(jsonResponse => proxsucesso())
        .catch(proxerro);
}

async function asyncApagarFuncionario(id, proxsucesso, proxerro) {
    const URL = `/api/funcionarios/${id}`;
    const deleteRequest = { method: 'DELETE' };
    fetch(URL, deleteRequest)
        .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta; })
        .then(resposta => proxsucesso())
        .catch(proxerro);
}

//area para usuario
async function asyncCriarUsuario(dadosUsuario, proxsucesso, proxerro) {
    const URL = `/api/usuarios`;
    const postRequest = {
        method: 'POST',
        body: JSON.stringify(dadosUsuario),
        headers: { 'Content-type': 'application/json' }
    };
    fetch(URL, postRequest)
        .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta; })
        .then(resposta => resposta.json())
        .then(jsonResponse => proxsucesso())
        .catch(proxerro);
}

async function asyncLerUsuarios(proxsucesso, proxerro) {
    const URL = `/api/usuarios`;
    fetch(URL)
        .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta; })
        .then(resposta => resposta.json())
        .then(jsonresponse => proxsucesso(jsonresponse))
        .catch(proxerro);
}

async function asyncLerUsuarioById(id, proxsucesso, proxerro) {
    const URL = `/api/usuarios/${id}`;
    fetch(URL)
        .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta; })
        .then(resposta => resposta.json())
        .then(jsonresponse => proxsucesso(jsonresponse))
        .catch(proxerro);
}

async function asyncAlterarUsuario(dadosUsuario, proxsucesso, proxerro) {
    const URL = `/api/usuarios/${dadosUsuario.id}`;
    const putRequest = {
        method: 'PUT',
        body: JSON.stringify(dadosUsuario),
        headers: { 'Content-type': 'application/json' }
    };
    fetch(URL, putRequest)
        .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta; })
        .then(resposta => resposta.json())
        .then(jsonResponse => proxsucesso())
        .catch(proxerro);
}

async function asyncApagarUsuario(id, proxsucesso, proxerro) {
    const URL = `/api/usuarios/${id}`;
    const deleteRequest = { method: 'DELETE' };
    fetch(URL, deleteRequest)
        .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta; })
        .then(resposta => proxsucesso())
        .catch(proxerro);
}
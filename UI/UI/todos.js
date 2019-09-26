console.log("-todos-");  


let todosBtn=document.getElementById("todos-btn")

todosBtn.addEventListener('click',e=>{
    let url="https://jsonplaceholder.typicode.com/todos?_limit=5";
    fetch(url)
    .then(esponse=>esponse.json())
    .then(todos=>{
        document.getElementById('todos').innerHTML=
        todos.map((todo)=>{
            return `
            <li class="list-group-item"><span>${todo.id}</span> <span>${todo.title} <span>${todo.completed}</span></span></li>
            `
        }).join(" ")
    })
})
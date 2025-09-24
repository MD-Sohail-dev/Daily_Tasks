const apiBaseUrl = "http://localhost:8081/api/tasks";

// Add Task
document.getElementById("addTaskForm").addEventListener("submit", async (e) => {
  e.preventDefault();
  const title = document.getElementById("title").value;
  const description = document.getElementById("description").value;

  const response = await fetch(apiBaseUrl, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ title, description })
  });

  if (response.ok) {
    alert("Task added successfully!");
    document.getElementById("addTaskForm").reset();
    getAllTasks(); // refresh task list
  } else {
    alert("Failed to add task");
  }
});

// Get All Tasks
async function getAllTasks() {
  const response = await fetch(apiBaseUrl);
  const tasks = await response.json();
  const taskList = document.getElementById("taskList");
  taskList.innerHTML = "";
  tasks.forEach(task => {
    const li = document.createElement("li");
    li.textContent = `${task.id}: ${task.title} - ${task.description}`;
    taskList.appendChild(li);
  });
}

// Get Task By ID
async function getTaskById() {
  const id = document.getElementById("taskIdInput").value;
  if (!id) return alert("Enter Task ID");
  const response = await fetch(`${apiBaseUrl}/${id}`);
  if (response.ok) {
    const task = await response.json();
    document.getElementById("taskDetails").textContent =
      `ID: ${task.id}, Title: ${task.title}, Description: ${task.description}`;
  } else {
    document.getElementById("taskDetails").textContent = "Task not found";
  }
}

// Delete Task
async function deleteTask() {
  const id = document.getElementById("deleteTaskId").value;
  if (!id) return alert("Enter Task ID to delete");
  const response = await fetch(`${apiBaseUrl}/${id}`, { method: "DELETE" });
  const message = await response.text();
  document.getElementById("deleteMessage").textContent = message;
  getAllTasks();
}

// Search Task (by title or keyword)
async function searchTask() {
  const keyword = document.getElementById("searchInput").value;
  if (!keyword) return alert("Enter search text");

  let response = await fetch(`${apiBaseUrl}/search/title/${keyword}`);
  let results = await response.json();

  // If no result in title search, try keyword
  if (results.length === 0) {
    response = await fetch(`${apiBaseUrl}/search/keyword/${keyword}`);
    results = await response.json();
  }

  const searchResults = document.getElementById("searchResults");
  searchResults.innerHTML = "";
  results.forEach(task => {
    const li = document.createElement("li");
    li.textContent = `${task.id}: ${task.title} - ${task.description}`;
    searchResults.appendChild(li);
  });
}


// Update Task
document.getElementById("updateTaskForm").addEventListener("submit", async (e) => {
  e.preventDefault();
  const id = document.getElementById("updateId").value;
  const title = document.getElementById("updateTitle").value;
  const description = document.getElementById("updateDescription").value;

  const response = await fetch(`${apiBaseUrl}/${id}`, {
    method: "PUT",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ title, description })
  });

  if (response.ok) {
    const updatedTask = await response.json();
    document.getElementById("updateMessage").textContent =
      `Task ${updatedTask.id} updated successfully!`;
    getAllTasks();
  } else {
    document.getElementById("updateMessage").textContent = "Failed to update task";
  }
});

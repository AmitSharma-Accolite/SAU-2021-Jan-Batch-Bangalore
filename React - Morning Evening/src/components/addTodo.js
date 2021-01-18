import React, { useState } from 'react';
import { Component } from 'react';
import List from './showList';
import "./styles.css";
class Todo extends Component {
  constructor(props) {
    super(props);
    this.state = {
      todoList: [],
      Task: {
        TaskName: "",
        date: new Date,

      }

    }
    this.addNew = this.addNew.bind(this);
    this.Save = this.Save.bind(this);
    this.Delete = this.Delete.bind(this);

  }

  addNew(e) {

    const newItem = this.state.Task;
    if (this.state.Task.TaskName !== "") {
      const items = [...this.state.todoList, newItem];
      this.setState({
        todoList: items,
        Task: {
          TaskName: "",
          date: new Date,

        }
      })
    }
  }

  Save(newTask, key) {
    const oldList = this.state.todoList;
    oldList.map(item => {
      if (item.date === key) {

        item.TaskName = newTask;
      }
    })
    this.setState({
      todoList: oldList
    })
  }

  Delete(key) {
    const updatedList = this.state.todoList.filter(item =>
      item.date !== key);

    this.setState({
      todoList: updatedList
    })

  }

  render() {
    return (

      <div className="container">
        <input type="text" placeholder="enter text" value={this.state.Task.TaskName} onChange={(e) => {
          this.setState({
            Task: {
              TaskName: e.target.value,
              date: Date.now()
            }
          })
        }} />

        <br />
        <button onClick={() => this.addNew()}>Add</button>
        <List todoData={this.state.todoList} Save={this.Save} Delete={this.Delete} />
      </div>);
  }
}


export default Todo;





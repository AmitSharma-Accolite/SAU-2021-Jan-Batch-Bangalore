import React from 'react';

import "./styles.css";

function List(props) {

    let todoItem = props.todoData;

    function sortList() {
        todoItem = todoItem.sort((a, b) => b.priority - a.priority);

    }
    sortList();
    const listItems = todoItem.map(item => {
        return <div className="list" key={item.date}>
            <p>

                <input disabled={true} type="text" id={item.date} value={item.TaskName}
                    onChange={(e) => {
                        props.Save(e.target.value, item.date)
                    }} />

                <button onClick={() => {
                    props.Delete(item.date)
                }}> Delete </button>
            </p>

        </div>
    })





    return (
        <div className="container">
            {listItems}

        </div>
    );
}
export default List;
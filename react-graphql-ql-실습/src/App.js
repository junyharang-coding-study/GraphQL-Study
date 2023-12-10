import './App.css';
import React, {useState} from 'react';
import {ApolloProvider} from "@apollo/client";
import {ApolloClient, InMemoryCache} from "@apollo/client";

import Roles from './components/roles'
import Teams from './components/teams'

const apolloClient = new ApolloClient({
    uri: "http://localhost:8081/graphql",
    cache: new InMemoryCache(),
});

function App() {

    const [menu, setMenu] = useState('Teams')

    let mainComp = {
        Roles: (<Roles/>),
        Teams: (<Teams/>),
    }

    function NavMenus() {
        return [
            'Roles', 'Teams'
        ].map((_menu, key) => {
            return (
                <li key={key} className={menu === _menu ? 'on' : ''}
                    onClick={() => {
                        setMenu(_menu);
                    }}>{_menu}</li>
            );
        });
    }

    return (
        <div className="App">
            <ApolloProvider client={apolloClient}>

                <header className="App-header">
                    <h1>
                        <a href="http://localhost:3000/">
                            <img rel="icon" src="favicon.ico" width="50px" height="50px"/>
                        </a>

                        <a href="https://junyharang.tistory.com/" target="_blank">
                            주니의 React Apollo Client 실습
                        </a>
                    </h1>
                    <nav>
                    <ul>
                            {NavMenus()}
                        </ul>
                    </nav>
                </header>
                <main>
                    {mainComp[menu]}
                </main>

                <footer className="App-footer">
                    <div style={{ display: 'flex', justifyContent: 'center', alignItems: 'center' }}>
                    <a href="https://junyharang.tistory.com/" target="_blank">
                        Copyright (c) 2023 juny(junyharang8592@gmail.com - https://junyharang.tistory.com/)
                    </a>
                    </div>
                </footer>

            </ApolloProvider>
        </div>
    );
}

export default App;
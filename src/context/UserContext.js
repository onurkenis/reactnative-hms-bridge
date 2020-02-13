import React, { useContext, useState, useMemo } from "react";

const Login = React.createContext({
    user: "",
    setUser: () => { },
    isLoggedIn: false,
    logOutUser: () => { },
});

export const useUser = () => useContext(Login);

export const UserContext = ({ children }) => {
    const [user, setUser] = useState("");

    const logOutUser = () => setUser("");

    const isLoggedIn = useMemo(() => {
        return user === "" ? false : true
    }, [user]);

    const context = { user, setUser, isLoggedIn, logOutUser }

    return (
        <Login.Provider value={context}>{children}</Login.Provider>
    );
};

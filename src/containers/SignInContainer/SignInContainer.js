import React, { useMemo } from 'react';

import { useUser } from '../../context/UserContext';
import SignInPage from '../../pages/SignInPage';
import ProfilePage from '../../pages/ProfilePage';

const SignInContainer = () => {
    const { isLoggedIn } = useUser();
    return useMemo(() => {
        return (
            !isLoggedIn ? <SignInPage /> : <ProfilePage />
        );
    });
};

export default SignInContainer;
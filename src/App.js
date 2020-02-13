import React from 'react';

import { UserContext } from './context/UserContext';
import SignInContainer from './containers/SignInContainer';

const App = () => {
  return (
    <UserContext>
      <SignInContainer/>
    </UserContext>
  );
};

export default App;

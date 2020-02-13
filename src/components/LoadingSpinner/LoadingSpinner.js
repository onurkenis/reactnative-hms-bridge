import React from 'react';

const LoadingSpinner = ({ isLoading }) => {
    return (
        isLoading ? <ActivityIndicator size="large" color="#0000ff" /> : null
    );
};

export default LoadingSpinner;

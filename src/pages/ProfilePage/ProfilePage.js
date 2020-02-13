import React, { useMemo } from 'react';
import { Text, View } from 'react-native';
import { useUser } from '../../context/UserContext';
import styles from './style'

const ProfilePage = () => {
    const { user } = useUser();

    return useMemo(() => {
        return (
            <View style={styles.container}>
                <Text>Welcome {user.displayName}</Text>
            </View>
        );
    }, [user]);
};

export default ProfilePage;
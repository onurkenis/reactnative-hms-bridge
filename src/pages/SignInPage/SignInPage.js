import React, { useState } from 'react';

import {
    Text,
    View,
    TouchableHighlight,
    TouchableOpacity,
    Alert,
    NativeModules
} from 'react-native';
import { useUser } from '../../context/UserContext';
import styles from './style'

const SignInPage = () => {

    const { setUser, logOutUser } = useUser();

    const testFlavor = () => NativeModules.ToastComponent.toastMe();

    const getPushToken = () => NativeModules.HMSPush.getToken();

    const sendEvent = (name, bundle) => NativeModules.HMSAnalytics.sendEvent(name, bundle);

    const login = () => {
        NativeModules.HMSLogin.Login().then((account) => {
            setUser(account);
        }, (code, message) => {
            logOutUser();
            console.log(message);
        });
    }

    return (
        <>
            <View style={styles.container}>
                <TouchableOpacity style={[styles.buttonContainer, styles.loginButton]} onPress={() => login()}>
                    <Text style={styles.loginText}>Login</Text>
                </TouchableOpacity>

                <TouchableHighlight style={styles.buttonContainer} onPress={() => testFlavor()}>
                    <Text>Test Flavor</Text>
                </TouchableHighlight>

                <TouchableHighlight style={styles.buttonContainer} onPress={() => getPushToken()}>
                    <Text>Get Push Token</Text>
                </TouchableHighlight>

                <TouchableHighlight style={styles.buttonContainer}
                    onPress={() => sendEvent("test", `{"message": "hi"}`)}>
                    <Text>Send Analytics Event</Text>
                </TouchableHighlight>

            </View>
        </>
    );
};

export default SignInPage;
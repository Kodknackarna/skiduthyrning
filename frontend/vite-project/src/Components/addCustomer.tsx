import { useState } from 'react';
import axios from 'axios';

// Axios instance med base URL
const api = axios.create({
    baseURL: 'http://localhost:8080/api'
});

export default function AddCustomer() {
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [email, setEmail] = useState('');
    const [phoneNumber, setPhoneNumber] = useState('');
    const [shoeSize, setShoeSize] = useState<number | ''>('');
    const [height, setHeight] = useState<number | ''>('');
    const [weight, setWeight] = useState<number | ''>('');
    const [message, setMessage] = useState<string | null>(null);
    const [error, setError] = useState<string | null>(null);
    // Skicka POST till backend för att skapa kund
    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        setMessage(null);
        setError(null);

        // Enkel validering
        if (!firstName || !lastName || !email) {
            setError('Fyll i förnamn, efternamn och email.');
            return;
        }

        const payload = {
            firstName,
            lastName,
            email,
            phoneNumber,
            shoeSize: typeof shoeSize === 'number' ? shoeSize : null,
            height: typeof height === 'number' ? height : null,
            weight: typeof weight === 'number' ? weight : null,
        } as unknown;

        try {
            const resp = await api.post('/customers', payload);
            setMessage('Kund skapad: ' + (resp.data?.firstName || ''));

            // Rensa formulär
            setFirstName('');
            setLastName('');
            setEmail('');
            setPhoneNumber('');
            setShoeSize('');
            setHeight('');
            setWeight('');
        } catch (err) {
            console.error('Error creating customer', err);
            const errMsg = axios.isAxiosError(err)
                ? err.response?.data?.message || err.message
                : 'Okänt fel vid skapande';
            setError(errMsg);
        }
    };

    return (
        <div className="add-customer-form">
            <h2>Lägg till Ny Kund</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Förnamn:</label>
                    <input type="text" value={firstName} onChange={(e) => setFirstName(e.target.value)} />
                </div>
                <div>
                    <label>Efternamn:</label>
                    <input type="text" value={lastName} onChange={(e) => setLastName(e.target.value)} />
                </div>
                <div>
                    <label>Email:</label>
                    <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} /> 
                </div>
                <div>
                    <label>Telefonnummer:</label>
                    <input type="text" value={phoneNumber} onChange={(e) => setPhoneNumber(e.target.value)} />
                </div>
                <div>
                    <label>Skostorlek:</label>
                    <input type="number" value={shoeSize} onChange={(e) => setShoeSize(e.target.value ? parseInt(e.target.value) : '')} />
                </div>
                <div>
                    <label>Längd (cm):</label>
                    <input type="number" value={height} onChange={(e) => setHeight(e.target.value ? parseInt(e.target.value) : '')} />
                </div>
                <div>
                    <label>Vikt (kg):</label>
                    <input type="number" value={weight} onChange={(e) => setWeight(e.target.value ? parseInt(e.target.value) : '')} />
                </div>
                <button type="submit">Lägg till Kund</button>
                {message && <div className="success-message">{message}</div>}
                {error && <div className="error-message">{error}</div>}
            </form>
        </div>
);
}
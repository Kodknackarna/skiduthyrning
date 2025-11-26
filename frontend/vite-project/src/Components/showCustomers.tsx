import { useState, useEffect } from 'react';
import axios from 'axios';

interface Customer {
    _id: string;
    firstName: string;
    lastName: string;
    email: string;
    phoneNumber: string;
    shoeSize: number;
    height: number;
    weight: number;
}

// Axios instance med base URL
const api = axios.create({
    baseURL: 'http://localhost:8080/api'
});

export function ShowCustomers() {
    const [customers, setCustomers] = useState<Customer[]>([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState<string | null>(null);

    useEffect(() => {
        // Hämta alla kunder från backend när komponenten monteras
        const fetchCustomers = async () => {
            try {
                const response = await api.get<Customer[]>('/customers');
                setCustomers(response.data);
                setError(null);
            } catch (error) {
                console.error('Error fetching customers:', error);
                const errorMessage = axios.isAxiosError(error) 
                    ? error.response?.data?.message || error.message 
                    : 'Okänt fel';
                setError(errorMessage);
            } finally {
                setLoading(false);
            }
        };

        fetchCustomers();
    }, []);

    if (loading) {
        return <div className="loading">Laddar kunder...</div>;
    }

    if (error) {
        return <div className="error">Fel vid hämtning av kunder: {error}</div>;
    }

    return (
        <div className="customers-container">
            <h2>Alla Kunder ({customers.length})</h2>
            
            {customers.length === 0 ? (
                <p>Inga kunder hittades i databasen.</p>
            ) : (
                <div className="customers-list">
                    {customers.map((customer, index) => (
                        <div key={customer._id} className="customer-card">
                            <h3>{index + 1}. {customer.firstName} {customer.lastName}</h3>
                            <p><strong>Email:</strong> {customer.email}</p>
                            <p><strong>Telefon:</strong> {customer.phoneNumber}</p>
                            <p><strong>Skostorlek:</strong> {customer.shoeSize}</p>
                            <p><strong>Längd:</strong> {customer.height} cm, <strong>Vikt:</strong> {customer.weight} kg</p>
                        </div>
                    ))}
                </div>
            )}
        </div>
    );
}

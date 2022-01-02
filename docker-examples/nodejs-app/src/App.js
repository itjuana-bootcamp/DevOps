import logo from './logo.svg';
import './App.css';
import {useEffect, useState} from "react";

const useCheckBackend = () => {
  const [version, setVersion] = useState('')
  const [loading, setLoading] = useState(false)
  const [error, setError] = useState(false)

  useEffect(() => {
    setLoading(true)
    fetch('http://localhost:3000/', {method: 'GET'}).then((res) => {
      if (res.status === 200) {
        res.json().then((json) => setVersion(json.version))
      } else {
        setError(true)
      }
    }).finally(() => {
      setLoading(false)
    })
  }, [])

  return {
    version,
    loading,
    error,
  }
};

function App() {
  const {version, loading, error} = useCheckBackend()

  if (loading) {
    return 'Loading...'
  }

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo"/>
        {error && (
          <p>Something went wrong :(</p>
        )}

        {!loading && version && (
          <>
            <p>
              Backend version {version}
            </p>
            <a
              className="App-link"
              href="https://docs.docker.com/"
              target="_blank"
              rel="noopener noreferrer"
            >
              Learn Docker
            </a>
          </>
        )}

      </header>
    </div>
  );
}

export default App;

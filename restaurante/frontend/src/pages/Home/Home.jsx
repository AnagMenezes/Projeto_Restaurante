import { Link } from 'react-router-dom'
import QuickLinks from '../../components/QuickLinks/QuickLinks'
import './Home.css'

function Home() {
  return (
    <>
      <main className="home">

        <div className="home-content">

          <span className="home-label">
            RESTAURANTE
          </span>

          <h1>
            Brasa de Carvalho
          </h1>

          <p>
            Sabores marcantes, bons momentos e aquele toque especial
            que transforma uma refeição em uma experiência.
          </p>
          

        </div>

      </main>

      <QuickLinks />
    </>
  )
}

export default Home
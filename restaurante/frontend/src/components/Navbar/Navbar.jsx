import { Link } from 'react-router-dom'
import './Navbar.css'

function Navbar() {
  return (
    <nav className="navbar">

      <Link to="/" className="navbar-logo">
        BRASA DE CARVALHO
      </Link>

      <div className="navbar-links">
        <Link to="/">Início</Link>
        <Link to="/cardapio">Cardápio</Link>
        <Link to="/sobre">Sobre</Link>
      </div>

    </nav>
  )
}

export default Navbar
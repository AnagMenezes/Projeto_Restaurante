import './Admin.css'
import AdminCard from '../../components/AdminCard/AdminCard'
import { Link } from 'react-router-dom'

function Admin() {
  return (
    <main className="admin">
      <h1>Painel Administrativo</h1>

      <p>
        Gerencie os produtos, categorias e pedidos do restaurante.
      </p>

    <div className="admin-cards">

  <Link to="/admin/produtos">
    <AdminCard
      titulo="Produtos"
      descricao="Cadastre e gerencie os produtos."
    />
  </Link>

  <Link to="/admin/categorias">
    <AdminCard
      titulo="Categorias"
      descricao="Cadastre e gerencie as categorias."
    />
  </Link>

  <Link to="/admin/pedidos">
    <AdminCard
      titulo="Pedidos"
      descricao="Acompanhe e gerencie os pedidos."
    />
  </Link>

  <Link to="/admin/promocoes">
    <AdminCard
      titulo="Promoções"
      descricao="Gerencie as promoções do restaurante."
    />
  </Link>

  <Link to="/admin/eventos">
    <AdminCard
      titulo="Eventos"
      descricao="Gerencie os eventos do restaurante."
    />
  </Link>

</div>
    </main>
  )
}

export default Admin
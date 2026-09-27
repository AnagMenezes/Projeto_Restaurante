import { useEffect, useState } from 'react'
import './Categorias.css'

function Categorias() {
  const [categorias, setCategorias] = useState([])
  const [carregando, setCarregando] = useState(true)
  const [nome, setNome] = useState('')
  const [editandoId, setEditandoId] = useState(null)
  const [novoNome, setNovoNome] = useState('')

  useEffect(() => {
    fetch('http://localhost:8080/categoria') 
        .then(response => response.json()) ///transforma o corpo e resposta jason
        .then(data => {
            setCategorias(data)
            setCarregando(false)
        })
    }, []) ///recebendo dois argumentos, a funcao é a primeira e a segunda é a lista vazia, que diz diz que a funcao deve abri uma unica vez, caso tivesse um argumento como um id, a funacao rodara sempre quando o id aparecesse.

    const cadastrarCategoria = (e) => {
        e.preventDefault()

        fetch('http://localhost:8080/categoria', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                nome: nome
            })
        })
            .then(response => response.json())
            .then(novaCategoria => {
            setCategorias([...categorias, novaCategoria])
            setNome('')
        })
    }

    const excluirCategoria = (id) => {
    const confirmar = window.confirm(
        'Tem certeza que deseja excluir esta categoria?'
    )

    if (!confirmar) {
        return
    }

    fetch(`http://localhost:8080/categoria/${id}`, {
        method: 'DELETE'
    })
        .then(response => {
            console.log('Status do DELETE:', response.status)

            if (!response.ok) {
                throw new Error('Erro ao excluir categoria')
            }

            setCategorias(
                categorias.filter(categoria => categoria.id !== id)
            )
        })
        .catch(error => {
            console.error(error)
        })
}

const editarCategoria = (categoria) => {
    setEditandoId(categoria.id)
    setNovoNome(categoria.nome)
}
    const salvarEdicao = (id) => {
  fetch(`http://localhost:8080/categoria/${id}`, {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({
      nome: novoNome
    })
  })
    .then(response => response.json())
    .then(categoriaAtualizada => {
      setCategorias(
        categorias.map(categoria =>
          categoria.id === id ? categoriaAtualizada : categoria
        )
      )

      setEditandoId(null)
      setNovoNome('')
    })
}

  return (
    <main className="categorias">
      <h1>Gerenciar Categorias</h1>

      <p>
        Cadastre e gerencie as categorias dos produtos do restaurante.
      </p>

      <form className="categoria-form" onSubmit={cadastrarCategoria}>
        <input
            type="text"
            placeholder="Nome da categoria"
            value={nome}
            onChange={(e) => setNome(e.target.value)}
        />

        <button type="submit">
            Cadastrar
        </button>
      </form>

      {carregando && <p>Carregando categorias...</p>}

      <div className="categorias-lista">
        {categorias.map((categoria) => (
            <div className="categoria-item" key={categoria.id}>

                {editandoId === categoria.id ? (
                    <>
                        <input
                            type="text"
                            value={novoNome}
                            onChange={(e) => setNovoNome(e.target.value)}
                        />

                        <button onClick={() => salvarEdicao(categoria.id)}>
                            Salvar
                        </button>
                    </>
                ) : (
                    <h2>{categoria.nome}</h2>
                )}

                <button onClick={() => editarCategoria(categoria)}>
                    Editar
                </button>

                <button onClick={() => excluirCategoria(categoria.id)}>
                    Excluir
                </button>

            </div>
        ))}
    </div>
    </main>
  )
}

export default Categorias